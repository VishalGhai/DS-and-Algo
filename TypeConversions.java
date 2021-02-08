public class TypeConversions {
    public static void main(String[] args) {
        
        //================================================================
        //INT CONVERSIONS
        //================================================================
        
        int a=1;

        //INT TO FLOAT
        float inttofloat=a;
        System.out.println("inttofloat : "+inttofloat);

        //INT TO DOUBLE
        double inttodouble=a;
        System.out.println("inttodouble : "+inttodouble);

        //INT TO CHAR
        char inttochar=(char)(a+48);
        System.out.println("inttochar : "+inttochar);

        //INT TO LONG
        long inttolong=a;
        System.out.println("inttolong : "+inttolong);

        //INT TO STRING
        String inttostring=String.valueOf(a);
        System.out.println("inttostring : "+inttostring);

        //BINARY VALUE AS A STRING
        String inttobinary=Integer.toBinaryString(a);
        System.out.println("inttobinary : "+inttobinary);


        //================================================================
        //FLOAT CONVERSIONS
        //================================================================

        float f=1.2f;

        //FLOAT TO INT
        int floattoint=(int)f;
        System.out.println("floattoint : "+floattoint);

        //FLOAT TO DOUBLE
        double floattodouble=Double.valueOf(Float.valueOf(f).toString()).doubleValue();
        System.out.println("floattodouble : "+floattodouble);

        //FLOAT TO CHAR
        char floattochar=(char)(f+48);
        System.out.println("floattochar : "+floattochar);

        //FLOAT TO LONG
        long floattolong=(long)f;
        System.out.println("floattolong : "+floattolong);

        //FLOAT TO STRING
        String floattostring=String.valueOf(f);
        System.out.println("floattostring : "+floattostring);

        //BINARY VALUE AS A STRING
        String floattobinary=Integer.toBinaryString(Float.floatToIntBits(f));
        System.out.println("floattobinary : "+floattobinary);
        
        //================================================================
        //LONG CONVERSIONS
        //================================================================

        long l=1;

        //LONG TO INT
        int longtoint=(int)l;
        System.out.println("longtoint : "+longtoint);

        //LONG TO DOUBLE
        double longtodouble=l;
        System.out.println("longtodouble : "+longtodouble);

        //LONG TO CHAR
        char longtochar=(char)(l+48);
        System.out.println("longtochar : "+longtochar);

        //LONG TO FLOAT
        float longtofloat=l;
        System.out.println("longtofloat : "+longtofloat);

        //LONG TO STRING
        String longtostring=String.valueOf(l);
        System.out.println("longtostring : "+longtostring);


        
        //================================================================
        //DOUBLE CONVERSIONS
        //================================================================

        double d=1.2d;

        //DOUBLE TO INT
        int doubletoint=(int)d;
        System.out.println("doubletoint : "+doubletoint);

        //DOUBLE TO LONG
        long doubletolong=(long)d;
        System.out.println("doubletolong : "+doubletolong);

        //DOUBLE TO CHAR
        char doubletochar=(char)(d+48);
        System.out.println("doubletochar : "+doubletochar);

        //DOUBLE TO FLOAT
        float doubletofloat=(float)d;
        System.out.println("doubletofloat : "+doubletofloat);

        //DOUBLE TO STRING
        String doubletostring=String.valueOf(d);
        System.out.println("doubletostring : "+doubletostring);


        
        //================================================================
        //STRING CONVERSIONS
        //================================================================

        String s="12";

        //STRING TO INT
        int Stringtoint=Integer.parseInt(s);
        System.out.println("Stringtoint : "+Stringtoint);

        //STRING TO LONG
        long Stringtolong=Long.parseLong(s);
        System.out.println("Stringtolong : "+Stringtolong);

        //STRING TO CHAR
        char Stringtochar=s.charAt(0);
        System.out.println("Stringtochar : "+Stringtochar);

        //STRING TO FLOAT
        float Stringtofloat=Float.parseFloat(s);
        System.out.println("Stringtofloat : "+Stringtofloat);

        //STRING TO DOUBLE
        double Stringtodouble=Double.parseDouble(s);
        System.out.println("Stringtodouble : "+Stringtodouble);

        //BINARY STRING TO FLOAT
        double binarytofloat=Double.longBitsToDouble(Long.parseLong(floattobinary,2));
        System.out.println("binarytofloat : "+binarytofloat);

        //================================================================
        //CHAR CONVERSIONS
        //================================================================

        char c='a';

        //CHAR TO STRING
        String chartoString=String.valueOf(c);
        System.out.println("chartoString : "+chartoString);

        //CHAR TO INT
        int chartoint=Character.getNumericValue(c);
        System.out.println("chartoint : "+chartoint);
    }
}
