//package com.example.dontworry;
//
//import com.example.dontworry.domain.help.Help;
//import com.example.dontworry.domain.law.Law;
//import com.example.dontworry.domain.posts.Posts;
//import com.example.dontworry.domain.punishment.Punishment;
//import com.example.dontworry.web.service.UserService;
//import com.example.dontworry.domain.user.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.PersistenceContext;
//import javax.swing.text.html.parser.Entity;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class InitData {
//
//    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//
//
//
//    private final EntityManagerFactory emf;
//    @PostConstruct
//    public void init(){
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        User user = User.builder()
//                .userId("s12")
//                .email("s1@naver.com")
//                .password(passwordEncoder.encode("s1234"))
//                .build();
//        em.persist(user);
//        // 미국 데이터
//        Help usaHelp1 = Help.builder()
//                .number("911")
//                .summary("There has been a crime or someone is at immediate risk of harm.")
//                .countryName("USA")
//                .build();
//        em.persist(usaHelp1);
//        Help usaHelp2 = Help.builder()
//                .number("Call or text 988")
//                .summary("To talk to someone now")
//                .countryName("USA")
//                .build();
//        em.persist(usaHelp2);
//        Help usaHelp3 = Help.builder()
//                .number("Use your preferred relay service or dial 711 then 988")
//                .summary("For deaf/hard of hearing")
//                .countryName("USA")
//                .build();
//        em.persist(usaHelp3);
//        Help usaHelp4 = Help.builder()
//                .number("Dial 988 then press 1")
//                .summary("For Veterans")
//                .countryName("USA")
//                .build();
//        em.persist(usaHelp4);
//        Help usaHelp5 = Help.builder()
//                .number("Call 988 and then press 2")
//                .summary("For Spanish speakers")
//                .countryName("USA")
//                .build();
//        em.persist(usaHelp5);
//        //중국
//        Help chinaHelp1 = Help.builder()
//                .number("12337")
//                .summary("全国扫黑除恶热线")
//                .countryName("CHINA")
//                .build();
//        em.persist(chinaHelp1);
//
//        Help chinaHelp2 = Help.builder()
//                .number("0312—8638639")
//                .summary("全国校园暴力举报电话")
//                .countryName("CHINA")
//                .build();
//        em.persist(chinaHelp2);
//
//        Help chinaHelp3 = Help.builder()
//                .number("110")
//                .summary("警方报案编号")
//                .countryName("CHINA")
//                .build();
//        em.persist(chinaHelp3);
//
//        Help chinaHelp4 = Help.builder()
//                .number("12320")
//                .summary("心理服务热线电话")
//                .countryName("CHINA")
//                .build();
//        em.persist(chinaHelp4);
//
//        Help chinaHelp5 = Help.builder()
//                .number("12345")
//                .summary("校园欺凌投诉电话(校园欺凌可以打)")
//                .countryName("CHINA")
//                .build();
//        em.persist(chinaHelp5);
//
//        // 일본
//        Help japanHelp1 = Help.builder()
//                .number("110")
//                .summary("警察に通報や通報をするために : 所轄警察署に直ちに接続")
//                .countryName("JAPAN")
//                .build();
//        em.persist(japanHelp1);
//
//        Help japanHelp2 = Help.builder()
//                .number("119")
//                .summary("緊急事態で救助が必要な時")
//                .countryName("JAPAN")
//                .build();
//        em.persist(japanHelp2);
//
//        Help japanHelp3 = Help.builder()
//                .number("#9110")
//                .summary("日常生活で起こるトラブル、暴力など、それぞれの相談進行 言語、年齢、性別などに関係なく、誰からの相談でも受け付けておりますので、お気軽にお電話ください")
//                .countryName("JAPAN")
//                .build();
//        em.persist(japanHelp3);
//
//        Help japanHelp4 = Help.builder()
//                .number("03-3501-0110")
//                .summary("東京都を管轄する警視庁総合相談センターにつながります")
//                .countryName("JAPAN")
//                .build();
//        em.persist(japanHelp4);
//
//        Help japanHelp5 = Help.builder()
//                .number("各学校のカウンセラーや教師に相談要請")
//                .summary("警察に連絡するのが負担な時、または問題に関する相談を希望する時")
//                .countryName("JAPAN")
//                .build();
//        em.persist(japanHelp5);
//
//
//        //한국
//        Help koreaHelp1 = Help.builder()
//                .number("117")
//                .summary("전국에서 발생되는 학교폭력 및 성폭력 등 피해자 신고를 접수하여, 즉시 긴급구조, \n" +
//                        "수사지시, One-Stop 또는 NGO 단체 연계 업무를 진행합니다.")
//                .countryName("KOREA")
//                .build();
//        em.persist(koreaHelp1);
//
//        Help koreaHelp2 = Help.builder()
//                .number("117")
//                .summary("117 학교폭력 신고센터 문자 신고 번호(요금 무료)")
//                .countryName("KOREA")
//                .build();
//        em.persist(koreaHelp2);
//
//        Help koreaHelp3 = Help.builder()
//                .number("117")
//                .summary("학교폭력을 당했을 경우, 주저하지 말고 관할 경찰서에 신고를 합니다.")
//                .countryName("KOREA")
//                .build();
//        em.persist(koreaHelp3);
//
//        Help koreaHelp4 = Help.builder()
//                .number("117")
//                .summary("탈골, 기도 막힘이나 그 밖의 위급사항이라고 판단된 경우 즉시 119에 도움을 청합니다.")
//                .countryName("KOREA")
//                .build();
//        em.persist(koreaHelp4);
//
//        Help koreaHelp5 = Help.builder()
//                .number("117")
//                .summary("학교폭력 전화상담, 인터넷 상담, 개인 및 집단상담.")
//                .countryName("KOREA")
//                .build();
//        em.persist(koreaHelp5);
//
//        Help koreaHelp6 = Help.builder()
//                .number("담임선생님 또는 학교 내 선생님과 상담")
//                .summary("누군가에게 털어놓는 다는 것은 커다란 의지가 될 수도 있습니다.")
//                .countryName("KOREA")
//                .build();
//        em.persist(koreaHelp6);
//
//        //중국 punishments
//        Punishment chinaPu = Punishment.builder()
//                .content("以暴力、胁迫或者其他方法勒索公私财物的，处3年以上10年以下有期徒刑")
//                .build();
//
//        List<Punishment> chinaP = new ArrayList<>();
//        chinaP.add(chinaPu);
//        em.persist(chinaPu);
////        //중국 LAW
//        Law chinaLaw = Law.builder()
//                .form("在校内、上下学途中、学校教育活动范围内，教师、学生或外来人员通过网络、设备对教师、学生进行语言、武力、身体、心理侵害")
//                .policy("侵犯名誉或财产也被视为校园暴力，校园暴力被归类为社会暴力的一种。")
//                .lawName("刑法第十七条（2021年3月1日修订）")
//                .punishments(chinaP)
//                .resolutionProcedures("叫我“110”并拉响警报。之后，立即向国家安全管理司报告。先口头，后书面。")
//                .countryName("CHINA")
//                .build();
//        em.persist(chinaLaw);
//        //일본 punishments
//        Punishment japanPu1 = Punishment.builder()
//                .content("暴行罪の場合、2年以下の懲役または300万ウォン以下の罰金または拘留に処する。")
//                .build();
//        Punishment japanPu2 = Punishment.builder()
//                .content("例外的な場合に, 加害生徒が14歳未満の場合、刑事処罰にはならないが、事案が重大な場合、同等に処罰を受ける。")
//                .build();
//
//        List<Punishment> japanP = new ArrayList<>();
//        japanP.add(japanPu1);
//        em.persist(japanPu1);
//        japanP.add(japanPu2);
//        em.persist(japanPu2);
//        //일본 LAW
//        Law japanLaw = Law.builder()
//                .form("差別、排斥、冷遇、無視、侮辱、いじめ、暴力などの形態を帯びる。")
//                .policy("重大事態への対処 : 自殺、深刻な心身の傷害や金品の損失を及ぼした場合、規定で法の加重値が増加する。")
//                .lawName("強制わいせつ、傷害、暴行、強要、窃盗、恐喝、器物損壊に該当する学校暴力犯罪は刑法で扱う")
//                .punishments(japanP)
//                .resolutionProcedures("校内暴力やいじめを早期発見するための努力をする。各学校ごとに相談員を配置し、" +
//                        "少年法制定などの解決策を提示してきており、被害者は校内暴力に遭う恐れがある場合、直ちに管轄警察署に通報し適切な援助を要請することを促す。")
//                .countryName("JAPAN")
//                .build();
//
//        em.persist(japanLaw);
//        tx.commit();
//        em.close();
//    }
//}
