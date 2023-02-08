package groupwork.dao;

//import groupwork.dao.memory.fabrics.GenreDaoSingleton;

//import groupwork.dao.db.GenreDaoDB;
//import groupwork.dao.db.orm.api.IManager;
//import groupwork.dao.db.orm.factory.EntityManagerVoteSingleton;
import groupwork.entity.Genre;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//import java.util.List;

class HibernateUtilGenreTest {
//    private static IManager manager;
    private static Logger logger = LogManager.getLogger();
    @Test
    public void testCreate() {
        System.out.println("Running testCreate...");
        logger.log(Level.INFO,"LOG Running testCreate..." );
        Genre genre = new Genre("rock" );
//        IManager manager = EntityManagerVoteSingleton.getInstance();
//        GenreDaoDB genreDaoDb = new GenreDaoDB(manager);
//        for (Genre val : genreDaoDb.getGenreList() ) {
//            genreDaoDb.delete(val);
//        }
//        genreDaoDb.insert(genre);
//        List<Genre> genreList = genreDaoDb.getGenreList();
//        Assertions.assertTrue(genreList.size() == 1);
    }
    @Test
    public void testDelete() {
        System.out.println("Running testCreate...");
        logger.log(Level.INFO,"LOG Running testDelete..." );
        Genre genre = new Genre("rock" );
        Genre genre1 = new Genre("jazz" );
//        IManager manager = EntityManagerVoteSingleton.getInstance();
//        GenreDaoDB genreDaoDb = new GenreDaoDB(manager);
//        for (Genre val : genreDaoDb.getGenreList() ) {
//            genreDaoDb.delete(val);
//        }
//        genreDaoDb.insert(genre);
//        genreDaoDb.insert(genre1);
//        genreDaoDb.delete(genre);
//        List<Genre> genreList = genreDaoDb.getGenreList();
//        Assertions.assertTrue(genreList.size() == 1);
    }
    @Test
    public void testIsContain() {
//        System.out.println("Running testCreate...");
//        Genre genre = new Genre("rock" );
//        Genre genre1 = new Genre("jazz" );
//        IManager manager = EntityManagerVoteSingleton.getInstance();
//        GenreDaoDB genreDaoDb = new GenreDaoDB(manager);
//        for (Genre val : genreDaoDb.getGenreList() ) {
//            genreDaoDb.delete(val);
//        }
//        genreDaoDb.insert(genre);
//        genreDaoDb.insert(genre1);
//        Assertions.assertTrue( genreDaoDb.exist(genre.getId()));
    }


//    @Test public void testUpdate() {
//        System.out.println("Running testUpdate...");
//
//        Integer id = 1;
//        GenreEntity genre = new GenreEntity(id,"country" );
//        GenreDAO_DB genreDAO_db = new GenreDAO_DB(manager);
//        genreDAO_db.update(genre);
//        GenreEntity updatedGenre = genreDAO_db.get(id);
////        EntityManager entityManager = manager.getEntityManager();
////
////        entityManager.getTransaction().begin();
////        entityManager.merge(genre);
////        entityManager.getTransaction().commit();
////
////        GenreEntity updatedGenre = entityManager.find(GenreEntity.class, id);
//
//        assertEquals("country", updatedGenre.getName());
//    }
//    @Test
//    public void testGet() {
//        System.out.println("Running testGet...");
//
//        Long id = 1L;
//        GenreDAO_DB genreDAO_db = new GenreDAO_DB(manager);
//        GenreEntity genre = genreDAO_db.get(id);
////        GenreEntity genre = session.find(GenreEntity.class, id);
//
//        assertEquals("country", genre.getName());
//    }
////    @Test
////    public void testList() {
////        System.out.println("Running testList...");
////
////        Query<GenreEntity> query = session.createQuery("from GenreEntity", GenreEntity.class);
////        List<GenreEntity> resultList = query.getResultList();
////
////        Assertions.assertFalse(resultList.isEmpty());
////    }
////    @Test
////    public void testDelete() {
////        System.out.println("Running testDelete...");
////
////        Integer id = 1;
////        GenreEntity genre = session.find(GenreEntity.class, id);
////
////        session.beginTransaction();
////        session.delete(genre);
////        session.getTransaction().commit();
////
////        GenreEntity deletedGenre = session.find(GenreEntity.class, id);
////
////        Assertions.assertNull(deletedGenre);
////    }
////    @BeforeEach
////    public void openSession() {
////        manager = EntityManagerVoteSingleton.getInstance();
////        System.out.println("Session created");
////    }
////
////    @AfterEach
////    public void closeSession() {
////        if (manager != null) manager.close();
////        System.out.println("Session closed\n");
////    }
//
//
////    @Test
//    public void getListFalse() {
//        try {
//            IGenreDao instance1 = GenreDaoDBSingleton.getInstance();
//
//            List<GenreEntity> genreList = instance1.getGenreList();
//            assertNotNull(genreList);
//            assertEquals(0, genreList.size());
//        } catch (PropertyVetoException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    public void addElement1() {
//        try {
//            IGenreDao instance1 = GenreDaoDBSingleton.getInstance();
//            GenreEntity rock = new GenreEntity("rock");
//            instance1.create(rock);
//            List<GenreEntity> genreList = instance1.getGenreList();
//            assertNotNull(genreList);
//            assertEquals(1, genreList.size());
//        } catch (PropertyVetoException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    public void addElement2() {
//        try {
//            IGenreDao instance1 = GenreDaoDBSingleton.getInstance();
//            GenreEntity rock1 = new GenreEntity("rock");
//            GenreEntity rock2 = new GenreEntity("rock");
//            instance1.create(rock1);
//            instance1.create(rock2);
//            List<GenreEntity> genreList = instance1.getGenreList();
//            assertNotNull(genreList);
//            assertEquals(3, genreList.size());
//        } catch (PropertyVetoException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    public void getElement1() {
//        try {
//            IGenreDao instance1 = GenreDaoDBSingleton.getInstance();
//            instance1.isContain(2);
//            GenreEntity genreEntity = instance1.get(2);
//
//            assertNotNull(genreEntity);
//            assertEquals(2, genreEntity.getId());
//        } catch (PropertyVetoException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Test
//    public void deleteElement1() {
//        try {
//            IGenreDao instance1 = GenreDaoDBSingleton.getInstance();
//            instance1.isContain(2);
//            GenreEntity genreEntity = instance1.get(2);
//            instance1.delete(genreEntity);
//
//            assertNotNull(genreEntity);
//            assertNull(instance1.isContain(2));
//        } catch (PropertyVetoException e) {
//            throw new RuntimeException(e);
//        }
//    }
}


//            Session session = sf.getSession();
//
//            SuperPowerType powerType = createSuperPowerType();
//            session.save(powerType);
//
//            SuperPower superpower = createSuperPower(powerType);
//            session.save(superpower);
//
//            SuperHero hero = createSuperHero(superpower);
//            session.save(hero);
//
//            sf.commit();
//
//            SuperHeroRepository heroRepository = new SuperHeroRepository(session);
//            List<SuperHero> heroes = heroRepository.loadBy(superpower);

//            assertNotNull(heroes);
//            assertEquals(1, heroes.size());


//
//    @Test
//    public void testGenreDaoTrue() {
//        int numberGenreTrue = 1;
//        boolean result = GenreDaoSingleton.getInstance().isContain(numberGenreTrue);
//        assertTrue(result);
//    }
//
//    @Test
//    public void testGenreDaoFalse() {
//        int numberGenreFalse = 11;
//        boolean result = GenreDaoSingleton.getInstance().isContain(numberGenreFalse);
//        assertFalse(result);
//    }
