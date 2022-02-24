package com.xhn.light.search.consumer;

import com.xhn.light.common.config.RabbitMqConfiguration;
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
 * @date ：2022/2/24 15:03
 * @description：
 */
@Component
public class UserAddMQ {
    @Autowired
    private ElasticSaveService elasticSaveService;

    @RabbitListener(queuesToDeclare = @Queue("register_es"))
    public void addGameToEs( Map<String, Object> map) throws IOException {
        ElasticSearchModel model = new ElasticSearchModel();
        model.setId((Long) map.get("id"));
        model.setName((String) map.get("name"));
        model.setTypeSearch(0);
        elasticSaveService.esSave(model);
    }
}
