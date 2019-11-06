package com.allen.dayup.thinkinjava.chap10;

/**
 * @Auther: 20190598
 * @Date: 2019/10/28 10:28
 * @Description:
 */
public class Parcell2 {

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

    public Content content(){
        return new Content();
    }

    public Destination to(String whereTo){
        return new Destination(whereTo);
    }

    public void ship(String dest){
        Content content = new Content();
        Destination destination = new Destination(dest);

        System.out.println(destination.getLabel());
    }

    public static void main(String[] args) {
        Parcell2 parcell2 = new Parcell2();
        parcell2.ship("Tasmania");

        Parcell2.Content content = parcell2.content();
        Parcell2.Destination destination = parcell2.to("Tasmania2");
        System.out.println(destination.getLabel());
    }
}
