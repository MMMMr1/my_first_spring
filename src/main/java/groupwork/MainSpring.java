package groupwork;

import groupwork.core.dto.GenreDTO;
import groupwork.core.dto.SingerDTO;
import groupwork.core.dto.VoiceDTO;
import groupwork.dao.db.GenreDaoDB;
import groupwork.dao.db.SingerDaoDB;
import groupwork.service.GenreService;
import groupwork.service.SingerService;
import groupwork.service.StatisticsService;
import groupwork.service.VoteService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.Map;


public class MainSpring {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("main-context.xml");

        GenreService genreServiceSpring = context.getBean("GenreServiceSpring", GenreService.class);
        GenreDaoDB genreDaoSpring = context.getBean("GenreDaoSpring", GenreDaoDB.class);
//        Manager managerSpring = context.getBean("ManagerSpring", Manager.class);
        logger.log(Level.INFO, "-----------------> getBeen GENRE");
        System.out.println(genreServiceSpring);
        System.out.println(genreDaoSpring);
        System.out.println();

        genreServiceSpring.create(new GenreDTO("jazz1"));
        genreServiceSpring.create(new GenreDTO("jazz2"));
        genreServiceSpring.create(new GenreDTO("jazz3"));
        genreServiceSpring.create(new GenreDTO("jazz4"));
        logger.log(Level.INFO, "-----------------> getAll GENRE");
        System.out.println(genreServiceSpring.get());
        System.out.println();
        logger.log(Level.INFO, "-----------------> update GENRE");
        genreServiceSpring.update(2,new GenreDTO("pop"));
        System.out.println(genreServiceSpring.get());
        System.out.println();
        logger.log(Level.INFO, "-----------------> check GENRE");
        System.out.println(genreServiceSpring.check(2));
        System.out.println(genreServiceSpring.get(2));
        System.out.println();
        logger.log(Level.INFO, "-----------------> delete GENRE");
        genreServiceSpring.delete(4);
        System.out.println(genreServiceSpring.get());
        System.out.println();


        SingerService singerServiceSpring = context.getBean("SingerServiceSpring", SingerService.class);
        SingerDaoDB singerDaoSpring = context.getBean("SingerDaoSpring", SingerDaoDB.class);
        logger.log(Level.INFO, "--////////---------------> getBeen Singer");
        System.out.println(singerServiceSpring);
        System.out.println(singerDaoSpring);
        System.out.println();
        singerServiceSpring.create(new SingerDTO("Maroon"));
        singerServiceSpring.create(new SingerDTO("Imagine Dragons"));
        singerServiceSpring.create(new SingerDTO("Cris Rea"));
        logger.log(Level.INFO, "--////////---------------> getAll Singer");
        System.out.println(singerServiceSpring.get());
        System.out.println();
        logger.log(Level.INFO, "--////////---------------> update Singer");
        singerServiceSpring.update(3,new SingerDTO("Madonna"));
        System.out.println(singerServiceSpring.get());
        System.out.println();
        logger.log(Level.INFO, "--////////---------------> check Singer");
        System.out.println(singerServiceSpring.check(3));
        System.out.println(singerServiceSpring.get(3));
        System.out.println();
        logger.log(Level.INFO, "--////////---------------> delete Singer");
        singerServiceSpring.delete(3);
        System.out.println(singerServiceSpring.get());
        System.out.println();

        VoteService voteServiceSpring = context.getBean("VoteServiceSpring", VoteService.class);
        StatisticsService statisticsServiceSpring = context.getBean("StatisticsServiceSpring", StatisticsService.class);
        logger.log(Level.INFO, "--////////----------!!!!!!!!!---------------> getBean VOTE & Statistics");
        System.out.println(voteServiceSpring);
        System.out.println(statisticsServiceSpring);
        System.out.println();

        voteServiceSpring.save(new VoiceDTO(2,new long[]{1,2,3},"hello1"));
        voteServiceSpring.save(new VoiceDTO(1,new long[]{1,2,3},"hello2"));
        voteServiceSpring.save(new VoiceDTO(2,new long[]{1,2,3},"hello3"));
        logger.log(Level.INFO, "--////////----------!!!!!!!!!---------------> getAll VOTES");
        System.out.println(voteServiceSpring.get());
        System.out.println();

        Map<GenreDTO, Integer> topGenre = statisticsServiceSpring.getTopGenre();
        logger.log(Level.INFO, "--////////----------!!!!!!!!!---------------> getAll topGenre");
        topGenre.forEach((k,v) -> System.out.println(k.getName() + " " + v));

        Map<SingerDTO, Integer> topSinger = statisticsServiceSpring.getTopSinger();
        logger.log(Level.INFO, "--////////----------!!!!!!!!!---------------> getAll topSinger");
        topSinger.forEach((k,v) -> System.out.println(k.getName() + " "+ v));

        Map<LocalDateTime, String> aboutUser = statisticsServiceSpring.getAboutUser();
        logger.log(Level.INFO, "--////////----------!!!!!!!!!---------------> getAll getAboutUser");
        aboutUser.forEach((k,v) ->  System.out.println(k + " " + v));
//    <bean id="GenreDaoSpring" class="groupwork.dao.db.GenreDaoDB">
//        <constructor-arg index="0" ref="ManagerSpring"/>
//    </bean>
//
//    <bean id="ManagerSpring" class="groupwork.dao.db.orm.manager.Manager"/>

//        IServiceA serviceAFromContext = context.getBean("helloServiceA", ServiceA.class);
//        IServiceA serviceAFromContext2 = context.getBean("helloServiceA", IServiceA.class);
////        IServiceA serviceAFromContext3 = context.getBean("helloServiceA2", IServiceA.class);
//        IServiceA serviceBeanType = context.getBean(IServiceA.class);`

//        System.out.println(serviceA);
//        System.out.println(serviceAFromContext);
//        System.out.println(serviceAFromContext2);
////        System.out.println(serviceAFromContext3);
//        System.out.println(serviceBeanType);
    }
}
