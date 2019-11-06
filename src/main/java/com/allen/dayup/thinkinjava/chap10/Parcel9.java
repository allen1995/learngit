package com.allen.dayup.thinkinjava.chap10;

/**
 * @Auther: 20190598
 * @Date: 2019/10/28 15:37
 * @Description:
 */
public class Parcel9 {

    public Destination destination(final String dest){
        return new Destination(){
            private String label = dest;

            public String readLabel(){
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 parcel9 = new Parcel9();
        Destination dest = parcel9.destination("Tasmania");
        System.out.println(dest.readLabel());
    }

    private class Destination {
        private String label;

        public Destination(String lavel) {
            this.label = lavel;
        }

        public Destination() {
        }

        public String readLabel(){
          return label;
        };
    }
}


