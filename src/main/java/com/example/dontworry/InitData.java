package com.example.dontworry;

import com.example.dontworry.domain.help.Help;
import com.example.dontworry.domain.posts.Posts;
import com.example.dontworry.web.service.UserService;
import com.example.dontworry.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();




    private final EntityManagerFactory emf;
    @PostConstruct
    public void init(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        User user = User.builder()
                .userId("s12")
                .email("s1@naver.com")
                .password(passwordEncoder.encode("s1234"))
                .build();
        em.persist(user);
        // 미국 데이터
        Help usaHelp1 = Help.builder()
                .number("911")
                .summary("There has been a crime or someone is at immediate risk of harm.")
                .countryName("USA")
                .build();
        em.persist(usaHelp1);
        Help usaHelp2 = Help.builder()
                .number("Call or text 988")
                .summary("To talk to someone now")
                .countryName("USA")
                .build();
        em.persist(usaHelp2);
        Help usaHelp3 = Help.builder()
                .number("Use your preferred relay service or dial 711 then 988")
                .summary("For deaf/hard of hearing")
                .countryName("USA")
                .build();
        em.persist(usaHelp3);
        Help usaHelp4 = Help.builder()
                .number("Dial 988 then press 1")
                .summary("For Veterans")
                .countryName("USA")
                .build();
        em.persist(usaHelp4);
        Help usaHelp5 = Help.builder()
                .number("Call 988 and then press 2")
                .summary("For Spanish speakers")
                .countryName("USA")
                .build();
        em.persist(usaHelp5);
        //중국
        Help chinaHelp1 = Help.builder()
                .number("12337")
                .summary("全国扫黑除恶热线")
                .countryName("CHINA")
                .build();
        em.persist(chinaHelp1);

        Help chinaHelp2 = Help.builder()
                .number("0312—8638639")
                .summary("全国校园暴力举报电话")
                .countryName("CHINA")
                .build();
        em.persist(chinaHelp2);

        Help chinaHelp3 = Help.builder()
                .number("110")
                .summary("警方报案编号")
                .countryName("CHINA")
                .build();
        em.persist(chinaHelp3);

        Help chinaHelp4 = Help.builder()
                .number("12320")
                .summary("心理服务热线电话")
                .countryName("CHINA")
                .build();
        em.persist(chinaHelp4);

        Help chinaHelp5 = Help.builder()
                .number("12345")
                .summary("校园欺凌投诉电话(校园欺凌可以打)")
                .countryName("CHINA")
                .build();
        em.persist(chinaHelp5);

        // 일본
        Help japanHelp1 = Help.builder()
                .number("110")
                .summary("警察に通報や通報をするために : 所轄警察署に直ちに接続")
                .countryName("JAPAN")
                .build();
        em.persist(japanHelp1);

        Help japanHelp2 = Help.builder()
                .number("119")
                .summary("緊急事態で救助が必要な時")
                .countryName("JAPAN")
                .build();
        em.persist(japanHelp2);

        Help japanHelp3 = Help.builder()
                .number("#9110")
                .summary("日常生活で起こるトラブル、暴力など、それぞれの相談進行 言語、年齢、性別などに関係なく、誰からの相談でも受け付けておりますので、お気軽にお電話ください")
                .countryName("JAPAN")
                .build();
        em.persist(japanHelp3);

        Help japanHelp4 = Help.builder()
                .number("03-3501-0110")
                .summary("東京都を管轄する警視庁総合相談センターにつながります")
                .countryName("JAPAN")
                .build();
        em.persist(japanHelp4);

        Help japanHelp5 = Help.builder()
                .number("各学校のカウンセラーや教師に相談要請")
                .summary("警察に連絡するのが負担な時、または問題に関する相談を希望する時")
                .countryName("JAPAN")
                .build();
        em.persist(japanHelp5);


        tx.commit();
        em.close();
    }
}
