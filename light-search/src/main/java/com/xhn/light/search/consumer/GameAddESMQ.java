package com.xhn.light.search.consumer;

import com.xhn.light.common.es.ElasticSearchModel;
import com.xhn.light.search.service.ElasticSaveService;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author ：xhn
 * @date ：2022/2/24 14:35
 * @description： 在添加游戏的时候，把一些信息添加到es里面
 */
@Component
public class GameAddESMQ {

    @Autowired
    private ElasticSaveService elasticSaveService;

    @RabbitListener(queuesToDeclare = @Queue("es_game"))
    public void addGameToEs( Map<String, Object> map) throws IOException {
        ElasticSearchModel model = new ElasticSearchModel();
        model.setId((Long) map.get("id"));
        model.setName((String) map.get("name"));
        model.setTypeSearch(1);
        elasticSaveService.esSave(model);
    }

}
