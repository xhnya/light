package com.xhn.light.community.utils;

import cn.hutool.core.lang.hash.Hash;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xhn
 * @date 2022/3/7 21:19
 * @description: 敏感词汇过滤
 */
@Component
public class SensitiveFilter {

    //前缀数
    private class TrieNode{

        //关键字结束标识
        private boolean isKeywordEnd;

         //   key是下级字符，value是下级节点
        private Map<Character,TrieNode> subNodes=new HashMap<>();



        public boolean isKeywordEnd() {
            return isKeywordEnd;
        }

        public void setKeywordEnd(boolean keywordEnd) {
            isKeywordEnd = keywordEnd;
        }

        //添加子节点的方法
        public void addSubNode(Character c,TrieNode node){
            subNodes.put(c,node);
        }

        public TrieNode getSubNode(Character c){
            return subNodes.get(c);
        }

    }
}
