package ch3_code_point_length;

public class CodePointLengthExample {

    public static void main(String[] args) {
        String str = "𝔘𝔫𝔦𝔠𝔬𝔡𝔢";
        System.out.println("String : " +str);
        System.out.println("Length: " +str.length());
        //Output is 14
        System.out.println("Codepoint count = " 
                +str.codePointCount(0,str.length()));
        //Output is 7
    }

}
