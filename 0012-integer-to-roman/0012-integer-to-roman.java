class Solution {
    String ans ="";
    public String intToRoman(int num) {
        util(num);
        return ans;
    }
    public void util(int num){  // 994
        if(num == 0)
            return;
        if(num >= 1000){
            ans += "M";
            num -= 1000;
        }
        else if(num + 100 >= 1000){
            ans += "CM";
            num -= 900;
        }else if(num >= 500){
            ans += "D";
            num -= 500;
        }else if(num + 100 >= 500){
            ans += "CD";
            num -= 400;
        }else if(num >= 100){
            ans += "C";
            num -= 100;
        }else if(num  + 10 >= 100){
            ans += "XC";
            num -= 90;
        }else if(num>=50){ // // 80
            ans += "L";
            num -= 50;
        }else if(num+10 >= 50){
            ans += "XL";
            num -= 40;
        }else if(num >= 10){
            ans += "X";
            num -= 10;
        }else if(num + 1 >= 10){
            ans += "IX";
            num -= 9;
        }else if(num >= 5){
            ans += "V";
            num -= 5;
        }else if(num +1 >= 5){
            ans += "IV";
            num -= 4;
        }else{
            ans += "I";
            num -= 1;
        }
        util(num);
    }
}