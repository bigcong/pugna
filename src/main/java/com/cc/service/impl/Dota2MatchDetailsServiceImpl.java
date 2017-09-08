package com.cc.service.impl;

import com.cc.entity.Dota2GameItems;
import com.cc.entity.Dota2Heros;
import com.cc.entity.Dota2Leagues;
import com.cc.entity.Dota2MatchDetails;
import com.cc.mapper.Dota2MatchDetailsMapper;
import com.cc.service.Dota2GameItemsService;
import com.cc.service.Dota2HerosService;
import com.cc.service.Dota2LeaguesService;
import com.cc.service.Dota2MatchDetailsService;
import com.cc.util.Dota2Utils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * dota2_match_details
 */
@Service
public class Dota2MatchDetailsServiceImpl implements Dota2MatchDetailsService {
    @Autowired
    private Dota2MatchDetailsMapper dota2MatchDetailsMapper;

    @Autowired
    private Dota2Utils dota2Utils;
    @Autowired
    private Dota2HerosService dota2HerosService;

    @Autowired
    private Dota2GameItemsService dota2GameItemsService;

    @Autowired
    private Dota2LeaguesService dota2LeaguesService;

    @Value("${dota2.heros.image_url}")
    private String imageUrl;

    @Override
    public List<Dota2MatchDetails> listPageDota2MatchDetails(Dota2MatchDetails dota2MatchDetails) {
        return dota2MatchDetailsMapper.listPageDota2MatchDetails(dota2MatchDetails);
    }

    @Override
    public Integer getDota2MatchDetailsCount() {
        return dota2MatchDetailsMapper.getDota2MatchDetailsCount();
    }

    @Override
    public void insert(Dota2MatchDetails dota2MatchDetails) {
        dota2MatchDetailsMapper.insert(dota2MatchDetails);
    }

    @Override
    public Dota2MatchDetails getDota2MatchDetailsById(Integer id) {
        return dota2MatchDetailsMapper.getDota2MatchDetailsById(id);
    }

    @Override
    public List<Dota2MatchDetails> listDota2MatchDetails(Dota2MatchDetails dota2MatchDetails) {
        return dota2MatchDetailsMapper.listDota2MatchDetails(dota2MatchDetails);
    }

    @Override
    public void updateDota2MatchDetails(Dota2MatchDetails dota2MatchDetails) {
        dota2MatchDetailsMapper.updateDota2MatchDetails(dota2MatchDetails);
    }

    @Override
    public void deleteDota2MatchDetails(Dota2MatchDetails dota2MatchDetails) {
        dota2MatchDetailsMapper.deleteDota2MatchDetails(dota2MatchDetails);
    }

    @Override
    public void deleteDota2MatchDetailsByIds(String[] ids) {
        dota2MatchDetailsMapper.deleteDota2MatchDetailsByIds(ids);
    }

    @Override
    public void insertSelective(Dota2MatchDetails dota2MatchDetails) {
        dota2MatchDetailsMapper.insertSelective(dota2MatchDetails);
    }

    @Override
    public void updateByPrimaryKeySelective(Dota2MatchDetails dota2MatchDetails) {
        dota2MatchDetailsMapper.updateByPrimaryKeySelective(dota2MatchDetails);
    }

    @Async
    public void matchDetails(Long match_id) {
        Map<String, Object> map = new HashMap<>();
        map.put("match_id", match_id);
        String g = dota2Utils.get("IDOTA2Match_570/GetMatchDetails", map);
        Gson gg = new Gson();
        JsonObject s = gg.fromJson(g, JsonObject.class);
        JsonObject result = s.get("result").getAsJsonObject();
        Dota2MatchDetails j = gg.fromJson(result.toString(), Dota2MatchDetails.class);
        JsonElement play = result.get("players");
        if (play != null) {
            j.setPlayer(play.getAsJsonArray().toString());
        }
        JsonElement picksBan = result.get("picks_bans");
        if (picksBan != null) {
            j.setPicksBan(picksBan.getAsJsonArray().toString());
        }

        if (j.getDuration() > 600) {


            try {


                dota2MatchDetailsMapper.insertSelective(j);

            } catch (Exception e) {
                System.out.println(e.getClass().getSimpleName());
                System.out.println(e instanceof MySQLIntegrityConstraintViolationException);


                if (e instanceof DuplicateKeyException) {

                } else {
                    System.out.println(g);
                    e.printStackTrace();

                }

            }


        }


    }

    /**
     * 每十分钟执行一次
     */
    @Scheduled(cron = "0 0/10 * * * ?")
    public void matchHistory() {
        Gson gg = new Gson();
        Dota2Leagues dota2Leagues = new Dota2Leagues();
        List<Dota2Leagues> dota2Leagues1 = dota2LeaguesService.listDota2Leagues(dota2Leagues);
        List<Dota2Leagues> leagues = new ArrayList<>();
        if (dota2Leagues1.size() > 100) {
            leagues = dota2Leagues1;

        } else {
            leagues = dota2Leagues1.subList(dota2Leagues1.size() - 100, dota2Leagues1.size());
        }


        Map<String, Object> map = new HashMap<>();
        map.put("matches_requested", 100);
        map.put("game_mode", 2);
        map.put("min_players", 10);
        map.put("tournament_games_only", 1);
        map.put("league_id", leagues.get(new Random().nextInt(leagues.size())).getLeagueid());


        String g = dota2Utils.get("IDOTA2Match_570/GetMatchHistory", map);


        JsonObject s = gg.fromJson(g, JsonObject.class);


        JsonArray matches = s.get("result").getAsJsonObject().get("matches").getAsJsonArray();


        for (int i = 0; i < matches.size(); i++) {


            long match_id = matches.get(i).getAsJsonObject().get("match_id").getAsLong();

            Dota2MatchDetails dota2MatchDetails = new Dota2MatchDetails();
            dota2MatchDetails.setMatchId(match_id);


            List<Dota2MatchDetails> list = listDota2MatchDetails(dota2MatchDetails);
            if (list != null && list.size() > 0) {
                continue;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            matchDetails(match_id);

        }


    }

    /**
     * 表示每个星期三中午12点
     */
    @Scheduled(cron = "0 0 11 ? * WED")
    public void heroes() {
        Map<String, Object> map = new HashMap<>();
        map.put("language", "zh_cn");

        String g = dota2Utils.get("IEconDOTA2_570/GetHeroes", map);


        Gson gg = new Gson();

        JsonObject s = gg.fromJson(g, JsonObject.class);

        System.out.println(g);


        JsonArray heroes = s.get("result").getAsJsonObject().get("heroes").getAsJsonArray();

        List<Dota2Heros> list = gg.fromJson(heroes, new TypeToken<List<Dota2Heros>>() {
        }.getType());

        for (Dota2Heros h : list) {
            String heroName = imageUrl + h.getName().replace("npc_dota_hero_", "");
            h.setFullPng(heroName + "_full.png");
            h.setLgPng(heroName + "_lg.png");
            h.setSbPng(heroName + "_sb.png");
            h.setVertJpg(heroName + "_vert.jpg");


            try {
                dota2HerosService.insertSelective(h);


            } catch (Exception e) {
                if (e instanceof DuplicateKeyException) {

                } else {
                    e.printStackTrace();

                }

            }

        }


        System.out.println(g);


    }

    /**
     * 周一至周五的上午10:15触发
     */
    @Scheduled(cron = "0 15 10 ? * MON-FRI")
    public void gameItems() {
        Map<String, Object> map = new HashMap<>();
        map.put("language", "zh_cn");

        String g = dota2Utils.get("IEconDOTA2_570/GetGameItems", map);
        System.out.println(g);
        Gson gg = new Gson();

        JsonObject s = gg.fromJson(g, JsonObject.class);
        JsonArray heroes = s.get("result").getAsJsonObject().get("items").getAsJsonArray();

        List<Dota2GameItems> list = gg.fromJson(heroes, new TypeToken<List<Dota2GameItems>>() {
        }.getType());

        for (Dota2GameItems items : list) {
            try {
                dota2GameItemsService.insertSelective(items);

            } catch (Exception e) {

                if (e instanceof DuplicateKeyException) {

                } else {
                    e.printStackTrace();

                }

            }
        }


    }


    /**
     * 表示每个星期三中午12点
     */
    @Override
    @Scheduled(cron = "0 0 12 ? * WED")
    public void leagues() {
        Map<String, Object> map = new HashMap<>();
        map.put("language", "zh_cn");

        String g = dota2Utils.get("IDOTA2Match_570/GetLeagueListing", map);

        System.out.println(g);
        Gson gg = new Gson();

        JsonObject s = gg.fromJson(g, JsonObject.class);
        JsonArray heroes = s.get("result").getAsJsonObject().get("leagues").getAsJsonArray();

        List<Dota2Leagues> list = gg.fromJson(heroes, new TypeToken<List<Dota2Leagues>>() {
        }.getType());

        for (Dota2Leagues leagues : list) {
            try {
                dota2LeaguesService.insertSelective(leagues);

            } catch (Exception e) {

                if (e instanceof DuplicateKeyException) {

                } else {
                    e.printStackTrace();

                }

            }
        }


    }


}