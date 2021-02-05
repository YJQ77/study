package com.example.basic.login;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Author: YinJiaqi
 * Date: 9/22/2020 4:37 PM
 * Content:
 */
public class LoginTest {
    private static final int HEX_TWO_FIVE_FIVE = 0x00FF;

    public static void main(String[] args){
//        String password = "a123456";
//        String username = "yinjiaqi";
//        String secret = encryptMd5("tgcheck", password);
//        String token = JWTUtil.createToken(username, secret);
//
//        Subject user = SecurityUtils.getSubject();
//        user.login(new JWTToken(token,0));
//        UserDto userDto = (UserDto) user.getPrincipals().getPrimaryPrincipal();
//        userDto.setToken(token);

        String s = "{\n" +
                "        \"人教版\":[\n" +
                "        \n" +
                "\t\t\t{\n" +
                "                \"which_one\":\"第一章\",\n" +
                "                \"name\":\"Unit 1 Hello!\",\n" +
                "                \"charpters\":[\n" +
                "                    {\n" +
                "                        \"charpterName\":\"词汇短语\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"文具类单词\",\n" +
                "                                \"course\":[\n" +
                "                                    \"文具类单词\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"指令短语\",\n" +
                "                                \"course\":[\n" +
                "                                    \"指令短语\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"句型\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"问候句子\",\n" +
                "                                \"course\":[\n" +
                "                                    \"问候句子\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"字母\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"26个字母全认知\",\n" +
                "                                \"course\":[\n" +
                "                                    \"26个字母全认知\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },{\n" +
                "                \"which_one\":\"第二章\",\n" +
                "                \"name\":\"Unit 2 Colours\",\n" +
                "                \"charpters\":[\n" +
                "                    {\n" +
                "                        \"charpterName\":\"词汇短语\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"颜色类单词\",\n" +
                "                                \"course\":[\n" +
                "                                    \"颜色类单词\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "\t\t\t\t\t\t\t{\n" +
                "                                \"pointsName\":\"指令句子\",\n" +
                "                                \"course\":[\n" +
                "                                    \"指令句子\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"句型\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"基础句型-礼貌用语\",\n" +
                "                                \"course\":[\n" +
                "                                    \"基础句型-礼貌用语\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "\t\t\t\t\t{\n" +
                "                        \"charpterName\":\"字母\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"字母a,b,c,d\",\n" +
                "                                \"course\":[\n" +
                "                                    \"字母a,b,c,d\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },{\n" +
                "                \"which_one\":\"第三章\",\n" +
                "                \"name\":\"Unit 3 Look at me!\",\n" +
                "                \"charpters\":[\n" +
                "                    {\n" +
                "                        \"charpterName\":\"词汇短语\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"身体部位单词\",\n" +
                "                                \"course\":[\n" +
                "                                    \"身体部位单词\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"句型\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"基础句型\",\n" +
                "                                \"course\":[\n" +
                "                                    \"基础句型\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "\t\t\t\t\t\t\t{\n" +
                "                                \"pointsName\":\"指令句子\",\n" +
                "                                \"course\":[\n" +
                "                                    \"指令句子\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"字母\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"字母e,f,g,h,i\",\n" +
                "                                \"course\":[\n" +
                "                                    \"字母e,f,g,h,i\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },{\n" +
                "                \"which_one\":\"第四章\",\n" +
                "                \"name\":\"Unit4 We love animals?\",\n" +
                "                \"charpters\":[\n" +
                "                    {\n" +
                "                        \"charpterName\":\"词汇短语\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"动物类单词\",\n" +
                "                                \"course\":[\n" +
                "                                    \"动物类单词\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"句型\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"基础句型\",\n" +
                "                                \"course\":[\n" +
                "                                    \"基础句型\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "\t\t\t\t\t\t\t{\n" +
                "                                \"pointsName\":\"指令类句子\",\n" +
                "                                \"course\":[\n" +
                "                                    \"指令类句子\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"字母\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"字母j,k,l,m,n\",\n" +
                "                                \"course\":[\n" +
                "                                    \"字母j,k,l,m,n\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },{\n" +
                "                \"which_one\":\"第五章\",\n" +
                "                \"name\":\"Unit 5 Let's eat！\",\n" +
                "                \"charpters\":[\n" +
                "                    {\n" +
                "                        \"charpterName\":\"词汇短语\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"食物类单词\",\n" +
                "                                \"course\":[\n" +
                "                                    \"食物类单词\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"句型\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"表达自己想要吃什么句型\",\n" +
                "                                \"course\":[\n" +
                "                                    \"表达自己想要吃什么句型\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "\t\t\t\t\t\t\t{\n" +
                "                                \"pointsName\":\"指令类句子\",\n" +
                "                                \"course\":[\n" +
                "                                    \"指令类句子\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"字母\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"字母o,p,q,r,s,t\",\n" +
                "                                \"course\":[\n" +
                "                                    \"字母o,p,q,r,s,t\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },{\n" +
                "                \"which_one\":\"第六章\",\n" +
                "                \"name\":\"Unit 6 Happy birthday!\",\n" +
                "                \"charpters\":[\n" +
                "                    {\n" +
                "                        \"charpterName\":\"词汇短语\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"数字类单词\",\n" +
                "                                \"course\":[\n" +
                "                                    \"数字类单词\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"句型\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"生日祝福及询问年龄句型\",\n" +
                "                                \"course\":[\n" +
                "                                    \"生日祝福及询问年龄句型\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"字母\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"字母u,v,w,x,y,z\",\n" +
                "                                \"course\":[\n" +
                "                                    \"字母u,v,w,x,y,z\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]\n" +
                "   ,\n" +
                "        \"外研版\":[\n" +
                "            {\n" +
                "                \"which_one\":\"第一章\",\n" +
                "                \"name\":\"Module 1\",\n" +
                "                \"charpters\":[\n" +
                "                    {\n" +
                "                        \"charpterName\":\"Unit 1 I'm Sam.\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 词汇梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 词汇讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇讲练\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 句型梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 句型讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型讲练\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"Unit 2 How are you?\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 词汇梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 词汇讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇讲练\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 句型梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 句型讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型讲练\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },\n" +
                "\t\t\t{\n" +
                "                \"which_one\":\"第二章\",\n" +
                "                \"name\":\"Module 2\",\n" +
                "                \"charpters\":[\n" +
                "                    {\n" +
                "                        \"charpterName\":\"Unit 1 I'm Ms Smart.\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 词汇梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 词汇讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇讲练\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 句型梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 句型讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型讲练\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"Unit 2 What's your name?\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 词汇梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 词汇讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇讲练\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 句型梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 句型讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型讲练\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },{\n" +
                "                \"which_one\":\"第三章\",\n" +
                "                \"name\":\"Module 3\",\n" +
                "                \"charpters\":[\n" +
                "                    {\n" +
                "                        \"charpterName\":\"Unit 1 Point to door.\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 词汇梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 词汇讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇讲练\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 句型梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 句型讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型讲练\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"Unit 2 Point to desk.\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 词汇梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 词汇讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇讲练\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 句型梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 句型讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型讲练\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },{\n" +
                "                \"which_one\":\"第四章\",\n" +
                "                \"name\":\"Module 4\",\n" +
                "                \"charpters\":[\n" +
                "                    {\n" +
                "                        \"charpterName\":\"Unit 1 It's red!\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 词汇梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 词汇讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇讲练\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 句型梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 句型讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型讲练\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"Unit 2 It's a black dog.\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 词汇梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 词汇讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇讲练\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 句型梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 句型讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型讲练\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },{\n" +
                "                \"which_one\":\"第五章\",\n" +
                "                \"name\":\"Module 5\",\n" +
                "                \"charpters\":[\n" +
                "                    {\n" +
                "                        \"charpterName\":\"Unit 1 How many?\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 词汇梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 词汇讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇讲练\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 句型梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 1 句型讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型讲练\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"Unit 2 Nine girls?\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 词汇梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 词汇讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"词汇讲练\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 句型梳理\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型梳理\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"Unit 2 句型讲练\",\n" +
                "                                \"course\":[\n" +
                "                                    \"句型讲练\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ],\n" +
                "        \"译林版\":[\n" +
                "            {\n" +
                "                \"which_one\":\"第一章\",\n" +
                "                \"name\":\"Unit 1 Hello!\",\n" +
                "                \"charpters\":[\n" +
                "                    {\n" +
                "                        \"charpterName\":\"storytime\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"storytime-词汇\",\n" +
                "                                \"course\":[\n" +
                "                                    \"storytime-词汇\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"storytime-故事\",\n" +
                "                                \"course\":[\n" +
                "                                    \"storytime-故事\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"grammar time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"grammar time-语法\",\n" +
                "                                \"course\":[\n" +
                "                                    \"grammar time-语法\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },{\n" +
                "                        \"charpterName\":\"sound time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"sound time-语音\",\n" +
                "                                \"course\":[\n" +
                "                                    \"sound time-语音\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },{\n" +
                "                        \"charpterName\":\"culture time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"culture time-文化拓展\",\n" +
                "                                \"course\":[\n" +
                "                                    \"culture time-文化拓展\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "\t\t\t\t\t{\n" +
                "                        \"charpterName\":\"cartoon time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"cartoon time-漫画故事\",\n" +
                "                                \"course\":[\n" +
                "                                    \"cartoon time-漫画故事\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },{\n" +
                "                \"which_one\":\"第二章\",\n" +
                "                \"name\":\"Unit 2 I'm Liu Tao\",\n" +
                "                \"charpters\":[\n" +
                "                    {\n" +
                "                        \"charpterName\":\"storytime\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"storytime-词汇\",\n" +
                "                                \"course\":[\n" +
                "                                    \"storytime-词汇\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"storytime-故事\",\n" +
                "                                \"course\":[\n" +
                "                                    \"storytime-故事\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"grammar time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"grammar time-语法\",\n" +
                "                                \"course\":[\n" +
                "                                    \"grammar time-语法\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },{\n" +
                "                        \"charpterName\":\"sound time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"sound time-语音\",\n" +
                "                                \"course\":[\n" +
                "                                    \"sound time-语音\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },{\n" +
                "                        \"charpterName\":\"culture time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"culture time-文化拓展\",\n" +
                "                                \"course\":[\n" +
                "                                    \"culture time-文化拓展\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "\t\t\t\t\t{\n" +
                "                        \"charpterName\":\"cartoon time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"cartoon time-漫画故事\",\n" +
                "                                \"course\":[\n" +
                "                                    \"cartoon time-漫画故事\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },{\n" +
                "                \"which_one\":\"第三章\",\n" +
                "                \"name\":\"Unit 3 My friends\",\n" +
                "                \"charpters\":[\n" +
                "                    {\n" +
                "                        \"charpterName\":\"storytime\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"storytime-词汇\",\n" +
                "                                \"course\":[\n" +
                "                                    \"storytime-词汇\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"storytime-故事\",\n" +
                "                                \"course\":[\n" +
                "                                    \"storytime-故事\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"grammar time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"grammar time-语法\",\n" +
                "                                \"course\":[\n" +
                "                                    \"grammar time-语法\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },{\n" +
                "                        \"charpterName\":\"sound time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"sound time-语音\",\n" +
                "                                \"course\":[\n" +
                "                                    \"sound time-语音\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },{\n" +
                "                        \"charpterName\":\"culture time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"culture time-文化拓展\",\n" +
                "                                \"course\":[\n" +
                "                                    \"culture time-文化拓展\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "\t\t\t\t\t{\n" +
                "                        \"charpterName\":\"cartoon time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"cartoon time-漫画故事\",\n" +
                "                                \"course\":[\n" +
                "                                    \"cartoon time-漫画故事\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },{\n" +
                "                \"which_one\":\"第四章\",\n" +
                "                \"name\":\"Unit 4 My family\",\n" +
                "                \"charpters\":[\n" +
                "                    {\n" +
                "                        \"charpterName\":\"storytime\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"storytime-词汇\",\n" +
                "                                \"course\":[\n" +
                "                                    \"storytime-词汇\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"storytime-故事\",\n" +
                "                                \"course\":[\n" +
                "                                    \"storytime-故事\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"grammar time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"grammar time-语法\",\n" +
                "                                \"course\":[\n" +
                "                                    \"grammar time-语法\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },{\n" +
                "                        \"charpterName\":\"sound time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"sound time-语音\",\n" +
                "                                \"course\":[\n" +
                "                                    \"sound time-语音\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },{\n" +
                "                        \"charpterName\":\"culture time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"culture time-文化拓展\",\n" +
                "                                \"course\":[\n" +
                "                                    \"culture time-文化拓展\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "\t\t\t\t\t{\n" +
                "                        \"charpterName\":\"cartoon time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"cartoon time-漫画故事\",\n" +
                "                                \"course\":[\n" +
                "                                    \"cartoon time-漫画故事\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            },{\n" +
                "                \"which_one\":\"第五章\",\n" +
                "                \"name\":\"Unit 5 Look at me!\",\n" +
                "                \"charpters\":[\n" +
                "                    {\n" +
                "                        \"charpterName\":\"storytime\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"storytime-词汇\",\n" +
                "                                \"course\":[\n" +
                "                                    \"storytime-词汇\"\n" +
                "                                ]\n" +
                "                            },\n" +
                "                            {\n" +
                "                                \"pointsName\":\"storytime-故事\",\n" +
                "                                \"course\":[\n" +
                "                                    \"storytime-故事\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"charpterName\":\"grammar time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"grammar time-语法\",\n" +
                "                                \"course\":[\n" +
                "                                    \"grammar time-语法\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },{\n" +
                "                        \"charpterName\":\"sound time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"sound time-语音\",\n" +
                "                                \"course\":[\n" +
                "                                    \"sound time-语音\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },{\n" +
                "                        \"charpterName\":\"culture time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"culture time-文化拓展\",\n" +
                "                                \"course\":[\n" +
                "                                    \"culture time-文化拓展\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    },\n" +
                "\t\t\t\t\t{\n" +
                "                        \"charpterName\":\"cartoon time\",\n" +
                "                        \"points\":[\n" +
                "                            {\n" +
                "                                \"pointsName\":\"cartoon time-漫画故事\",\n" +
                "                                \"course\":[\n" +
                "                                    \"cartoon time-漫画故事\"\n" +
                "                                ]\n" +
                "                            }\n" +
                "                        ]\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ]}\n" +
                "    \n";
        JSONObject object = JSONObject.parseObject(s.trim());
        JSONArray o = object.getJSONArray("人教版");
        for (int i = 0;i<o.size();i++){
            if(o.getJSONObject(i).getString("which_one").equals("第二章")){
                System.out.println(o.getJSONObject(i).getJSONArray("charpters"));
            }
        }
        //List<JavaBean> bean = JSON.parseArray(o.toJSONString(), JavaBean.class);
        System.out.println(o);

    }


    public static String encryptMd5(String rawInput, String salt) {
        String input = rawInput.toLowerCase();
        try {
            int middle = input.length() / 2;
            byte[] result = MessageDigest.getInstance("MD5").digest((input.substring(0, middle) + salt + input.substring(middle)).getBytes());
            StringBuilder strBuilder = new StringBuilder(result.length * 2);
            for (byte b : result) {
                String s = Integer.toHexString(b & HEX_TWO_FIVE_FIVE);
                if (1 == s.length()) {
                    strBuilder.append('0');
                }
                strBuilder.append(s);
            }
            return strBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
