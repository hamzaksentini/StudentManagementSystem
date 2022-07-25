public class tennis {

    public static void main(String[] args){


        String[] points = {"p1","p1","p2","p2"};
        int p1S,p2s ,setWonByP1,setWonByP2;



        for (String s : points){
            //-30
            if ( points[s] equals("p1") && p1S,p2s < 30) {
                p1S+=15;

            }
            else if (points[s] equals("p2") && p1S,p2s < 30){
                p2s+=15;
            }



            //=30
             else if (points[s] equals("p1") && p1S == 30){
                p1S+=10;
            }

             else if (points[s] equals("p1") && p2s == 30){
                p2s+=10;
            }



             //40+
              else if (points[s] equals("p1") && p1S == 40 && p2s <= 30){
                p1S=0;
                p2s=0;
                setWonByP1=++;
            }
              else if (points[s] equals("p2") && p2s == 40 && p1S <= 30){
                p1S=0;
                p2s=0;
                setWonByP2++;
            }

              //advantage
              else if (points[s] equals("p1") && p1S == 40 && p2s == 40){
                p1S=50;
            }

              else if (points[s] equals("p2") && p1S == 40 && p2s == 40){
                p2s=50;
            }


              //advantage won
              else if (points[s] equals("p1") && p1S == 50 && p2s == 40){
                p1S=0;
                p2s=0;
                setWonByP1=++;
            }
              else if (points[s] equals("p2") && p1S == 40 && p2s == 50){
                p1S=0;
                p2s=0;
                setWonByP2=++;
            }

              // advantage lost
              else if (points[s] equals("p2") && p1S == 50 && p2s == 40){
                p1S -= 10;
            }

              else if (points[s] equals("p1") && p1S == 40 && p2s == 50){
                p2s -= 10;
            }










        }


    }



}
