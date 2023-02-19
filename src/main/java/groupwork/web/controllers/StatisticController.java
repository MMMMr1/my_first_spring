package groupwork.web.controllers;

import groupwork.core.dto.statistic.StatisticModelDTO;
import groupwork.service.api.IStatisticsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/result")
public class StatisticController {
    private final IStatisticsService statisticsService;
    public StatisticController(IStatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }
    @RequestMapping(method = RequestMethod.GET)
    public   StatisticModelDTO getStatistic(){
        return statisticsService.getResult();
    }
}
