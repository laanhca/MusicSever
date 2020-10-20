package com.lva.musicserver;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MusicController {
    @GetMapping("api/searchSong")
    public List<Musics> searchSong(@RequestParam(value = "musicName", defaultValue = "") String musicName) {
        ArrayList musics = new ArrayList<Musics>();
        String link;
        Elements es = new Elements();
        if (!musicName.equals("")) { link= "https://chiasenhac.vn/tim-kiem?q="+ musicName.replace(" ","+");
        try {
             Document doc = Jsoup.connect(link).get();
             es= doc.select("div.tab-content").first()
                     .select("ul.list-unstyled")
                     .get(1)
                     .select("li.media");
        } catch (IOException e) {
            e.printStackTrace();
        }
        } else {
             link = "https://chiasenhac.vn/nhac-hot.html";
            try {
                Document doc = Jsoup.connect(link).get();

                es = doc.select("div.tab-content").get(2).select("li.media");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        for (int i=0;i< es.size();i++){

                String linkImage = es.get(i).select("img").first().attr("src");
                String songName = es.get(i).select("a").attr("title");
                String artistName = es.get(i).select("div.author").get(0).text();
                String linkSong = es.get(i).select("div.media-left").select("a").attr("href");
                musics.add(new Musics(linkImage, songName, artistName,
                                linkSong));}
        return musics;
    }
}
