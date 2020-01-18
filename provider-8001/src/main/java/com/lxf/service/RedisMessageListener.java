package com.lxf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author lxf
 * @date 2020/1/13 17:57
 * @modified
 * @description redis监听事件
 */
@Component
public class RedisMessageListener implements MessageListener {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("onPMessage pattern " + bytes + " " + " " + message);
        String channel = new String(message.getChannel());
        String str = (String) redisTemplate.getValueSerializer().deserialize(message.getBody());
        System.out.println(str+"PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP");
    }

}
