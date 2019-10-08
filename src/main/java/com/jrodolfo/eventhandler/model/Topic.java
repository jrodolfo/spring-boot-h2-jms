package com.jrodolfo.eventhandler.model;

public enum Topic {
    TOPIC_01(Constants.TOPIC_01_VALUE),
    TOPIC_02(Constants.TOPIC_02_VALUE);

    private String topicName;

    Topic(String name) {
        this.topicName = name;
    }

    @Override
    public String toString() {
        return topicName;
    }

    // We cannot use the toString() everywhere... If we try doing that in the following code, it does not work:
    //  @JmsListener(destination = Topic.TOPIC_01.toString(), <=== "Attribute value must be constant"
    // Therefore we define this Constants class to produce constant values
    // so that we can use like that: Topic.Constants.TOPIC_01_VALUE
    public static class Constants {
        public static final String TOPIC_01_VALUE = "topic_01";
        public static final String TOPIC_02_VALUE = "topic_02";
    }
}
