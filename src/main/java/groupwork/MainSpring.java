package groupwork;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MainSpring {
    static Logger logger = LogManager.getLogger();

//   public static void main(String[] args) {
//        try (var context = new ClassPathXmlApplicationContext("main-context.xml")) {

//        ApplicationContext context = new ClassPathXmlApplicationContext("main-context.xml");
//             GenreService genreService = context.getBean("genreService", GenreService.class);
//             GenreDaoDB genreDao = context.getBean("genreDao", GenreDaoDB.class);
////        Manager managerSpring = context.getBean("ManagerSpring", Manager.class);
//             logger.log(Level.INFO, "-----------------> getBeen GENRE");
//             System.out.println(genreService);
//              System.out.println(genreDao);
//             System.out.println();
//
//              genreService.insert(new GenreDTO("pop"));
//              genreService.insert(new GenreDTO("jazz"));
//            genreService.insert(new GenreDTO("classic"));
//             genreService.insert(new GenreDTO("rok"));
//             genreService.insert(new GenreDTO("hard - rok"));
//             genreService.insert(new GenreDTO("metal"));
//             genreService.insert(new GenreDTO("country"));
//              logger.log(Level.INFO, "-----------------> getAll GENRE");
//              System.out.println(genreService.get());
//              System.out.println();
//              logger.log(Level.INFO, "-----------------> update GENRE");
//              genreService.update(2, new GenreDTO("pop"));
//              System.out.println(genreService.get());
//              System.out.println();
//              logger.log(Level.INFO, "-----------------> check GENRE");
//              System.out.println(genreService.check(2));
//              System.out.println(genreService.get(2));
//              System.out.println();
//              logger.log(Level.INFO, "-----------------> delete GENRE");
//              genreService.delete(4);
//              System.out.println(genreService.get());
//              System.out.println();
//
//
//              SingerService singerService = context.getBean("singerService", SingerService.class);
//              SingerDaoDB singerDao = context.getBean("singerDao", SingerDaoDB.class);
//              logger.log(Level.INFO, "--////////---------------> getBeen Singer");
//              System.out.println(singerService);
//              System.out.println(singerDao);
//              System.out.println();
//              singerService.insert(new SingerDTO("Maroon"));
//              singerService.insert(new SingerDTO("Imagine Dragons"));
//              singerService.insert(new SingerDTO("Cris Rea"));
//              singerService.insert(new SingerDTO("Elton John"));
//              singerService.insert(new SingerDTO("Dua Lippa"));
//              singerService.insert(new SingerDTO("David Garret"));
//              logger.log(Level.INFO, "--////////---------------> getAll Singer");
//              System.out.println(singerService.get());
//              System.out.println();
//              logger.log(Level.INFO, "--////////---------------> update Singer");
//              singerService.update(3, new SingerDTO("Madonna"));
//              System.out.println(singerService.get());
//              System.out.println();
//              logger.log(Level.INFO, "--////////---------------> check Singer");
//              System.out.println(singerService.check(3));
//              System.out.println(singerService.get(3));
//              System.out.println();
//              logger.log(Level.INFO, "--////////---------------> delete Singer");
//              singerService.delete(3);
//              System.out.println(singerService.get());
//              System.out.println();
//
//              VoteService voteService = context.getBean("voteService", VoteService.class);
//              StatisticsService statisticsService = context.getBean("statisticsService", StatisticsService.class);
//              logger.log(Level.INFO, "--////////----------!!!!!!!!!---------------> getBean VOTE & Statistics");
//              System.out.println(voteService);
//              System.out.println(statisticsService);
//              System.out.println();
//
//              voteService.save(new VoiceDTO(2, new long[]{1, 2, 3}, "hello1"));
//              voteService.save(new VoiceDTO(1, new long[]{1, 5, 3}, "hello2"));
//              voteService.save(new VoiceDTO(2, new long[]{1, 6, 7}, "hello3"));
//              logger.log(Level.INFO, "--////////----------!!!!!!!!!---------------> getAll VOTES");
//              System.out.println(voteService.get());
//              System.out.println();
//
//              Map<GenreModelDTO, Integer> topGenre = statisticsService.getTopGenre();
//              logger.log(Level.INFO, "--////////----------!!!!!!!!!---------------> getAll topGenre");
//              topGenre.forEach((k, v) -> System.out.println(k.getName() + " " + v));
//
//              Map<SingerModelDTO, Integer> topSinger = statisticsService.getTopSinger();
//              logger.log(Level.INFO, "--////////----------!!!!!!!!!---------------> getAll topSinger");
//              topSinger.forEach((k, v) -> System.out.println(k.getName() + " " + v));
//
//              List<AboutRow> aboutUser = statisticsService.getAboutUser();
//              logger.log(Level.INFO, "--////////----------!!!!!!!!!---------------> getAll getAboutUser");
//              aboutUser.forEach((k ) -> System.out.println(k.getMessage() + " " + k.getCreationTime() ));
//         }
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
