package com.allen.dayup.thinkinjava.chap10;

/**
 * @Auther: 20190598
 * @Date: 2019/10/28 09:52
 * @Description:
 */
public class Parcell {

    class Content{
        private int value;

        public int getValue(){
            return value;
        }
    }

    class Destination{
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        public String getLabel(){
            return label;
        }
    }

    public void ship(String dest){
        Content content = new Content();
        Destination destination = new Destination(dest);

        System.out.println(destination.getLabel());
    }

    public static void main(String[] args) {
        Parcell parcell = new Parcell();
        parcell.ship("Destination Guangzhou");
    }
}
