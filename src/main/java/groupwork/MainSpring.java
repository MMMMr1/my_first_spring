package groupwork;

import groupwork.core.dto.*;
import groupwork.dao.db.GenreDaoDB;
import groupwork.dao.db.SingerDaoDB;
import groupwork.dao.db.orm.manager.Manager;
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
//        try (var context = new ClassPathXmlApplicationContext("main-context.xml")) {

        ApplicationContext context = new ClassPathXmlApplicationContext("main-context.xml");
             GenreService genreService = context.getBean("genreService", GenreService.class);
             GenreDaoDB genreDao = context.getBean("genreDao", GenreDaoDB.class);
//        Manager managerSpring = context.getBean("ManagerSpring", Manager.class);
             logger.log(Level.INFO, "-----------------> getBeen GENRE");
             System.out.println(genreService);
              System.out.println(genreDao);
             System.out.println();

              genreService.insert(new GenreDTO("jazz1"));
              genreService.insert(new GenreDTO("jazz2"));
            genreService.insert(new GenreDTO("jazz3"));
             genreService.insert(new GenreDTO("jazz4"));
              logger.log(Level.INFO, "-----------------> getAll GENRE");
              System.out.println(genreService.get());
              System.out.println();
              logger.log(Level.INFO, "-----------------> update GENRE");
              genreService.update(2, new GenreDTO("pop"));
              System.out.println(genreService.get());
              System.out.println();
              logger.log(Level.INFO, "-----------------> check GENRE");
              System.out.println(genreService.check(2));
              System.out.println(genreService.get(2));
              System.out.println();
              logger.log(Level.INFO, "-----------------> delete GENRE");
              genreService.delete(4);
              System.out.println(genreService.get());
              System.out.println();


              SingerService singerService = context.getBean("singerService", SingerService.class);
              SingerDaoDB singerDao = context.getBean("singerDao", SingerDaoDB.class);
              logger.log(Level.INFO, "--////////---------------> getBeen Singer");
              System.out.println(singerService);
              System.out.println(singerDao);
              System.out.println();
              singerService.insert(new SingerDTO("Maroon"));
              singerService.insert(new SingerDTO("Imagine Dragons"));
              singerService.insert(new SingerDTO("Cris Rea"));
              logger.log(Level.INFO, "--////////---------------> getAll Singer");
              System.out.println(singerService.get());
              System.out.println();
              logger.log(Level.INFO, "--////////---------------> update Singer");
              singerService.update(3, new SingerDTO("Madonna"));
              System.out.println(singerService.get());
              System.out.println();
              logger.log(Level.INFO, "--////////---------------> check Singer");
              System.out.println(singerService.check(3));
              System.out.println(singerService.get(3));
              System.out.println();
              logger.log(Level.INFO, "--////////---------------> delete Singer");
              singerService.delete(3);
              System.out.println(singerService.get());
              System.out.println();

              VoteService voteService = context.getBean("voteService", VoteService.class);
              StatisticsService statisticsService = context.getBean("statisticsService", StatisticsService.class);
              logger.log(Level.INFO, "--////////----------!!!!!!!!!---------------> getBean VOTE & Statistics");
              System.out.println(voteService);
              System.out.println(statisticsService);
              System.out.println();

              voteService.save(new VoiceDTO(2, new long[]{1, 2, 3}, "hello1"));
              voteService.save(new VoiceDTO(1, new long[]{1, 2, 3}, "hello2"));
              voteService.save(new VoiceDTO(2, new long[]{1, 2, 3}, "hello3"));
              logger.log(Level.INFO, "--////////----------!!!!!!!!!---------------> getAll VOTES");
              System.out.println(voteService.get());
              System.out.println();

              Map<GenreModelDTO, Integer> topGenre = statisticsService.getTopGenre();
              logger.log(Level.INFO, "--////////----------!!!!!!!!!---------------> getAll topGenre");
              topGenre.forEach((k, v) -> System.out.println(k.getName() + " " + v));

              Map<SingerModelDTO, Integer> topSinger = statisticsService.getTopSinger();
              logger.log(Level.INFO, "--////////----------!!!!!!!!!---------------> getAll topSinger");
              topSinger.forEach((k, v) -> System.out.println(k.getName() + " " + v));

              Map<LocalDateTime, String> aboutUser = statisticsService.getAboutUser();
              logger.log(Level.INFO, "--////////----------!!!!!!!!!---------------> getAll getAboutUser");
              aboutUser.forEach((k, v) -> System.out.println(k + " " + v));
         }
    }
//}
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

//}
