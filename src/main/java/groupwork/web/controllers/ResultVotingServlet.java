package groupwork.web.controllers;

//@WebServlet(name = "ResultVotingServlet", urlPatterns = "/result")
public class ResultVotingServlet   {
//    private final IStatisticsService statisticsService;
//
//    public ResultVotingServlet() {
//        this.statisticsService = StatisticServiceSingleton.getInstance();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html; charset=UTF-8");
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
//
//        PrintWriter writer = resp.getWriter();
//
//        StatisticDTO allSort = statisticsService.getResult();
//
//        writer.write("<p>Результаты голосования за лучшего исполнителя:</p>");
//        for (Map.Entry<SingerDTO, Integer> entry : allSort.getMapSingers().entrySet()) {
//            writer.write("<p>" + entry.getKey() + " -> " + entry.getValue() + "</p>");
//        }
//
//        writer.write("<p>Результаты голосования за лучший жанр:</p>");
//        for (Map.Entry<GenreDTO, Integer> entry : allSort.getMapGenres().entrySet()) {
//            writer.write("<p>" + entry.getKey() + " -> " + entry.getValue() + "</p>");
//        }
//
//        writer.write("<p>О пользователе:</p>");
//        for (Map.Entry<LocalDateTime, String> entry : allSort.getMapUserInfo().entrySet()) {
//            writer.write("<p>" + entry.getValue() + " -> " + dtf.format(entry.getKey() ) + "</p>");
//        }
//
//    }
}
