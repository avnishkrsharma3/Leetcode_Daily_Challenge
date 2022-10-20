class Solution {
    StringBuilder ans ;
    public String intToRoman(int num) {
        ans = new StringBuilder();
        util(num);
        return ans.toString();
    }
    public void util(int num){  // 994
        if(num == 0)
            return;
        if(num >= 1000){
            ans.append("M");
            num -= 1000;
        }
        else if(num + 100 >= 1000){
            ans.append("CM");
            num -= 900;
        }else if(num >= 500){
            ans.append("D");
            num -= 500;
        }else if(num + 100 >= 500){
            ans.append("CD");
            num -= 400;
        }else if(num >= 100){
            ans.append("C");
            num -= 100;
        }else if(num  + 10 >= 100){
            ans.append("XC");
            num -= 90;
        }else if(num>=50){ // // 80           
            ans.append("L");
            num -= 50;
        }else if(num+10 >= 50){
            ans.append("XL");
            num -= 40;
        }else if(num >= 10){
            ans.append("X");
            num -= 10;
        }else if(num + 1 >= 10){
            ans.append("IX");
            num -= 9;
        }else if(num >= 5){
            ans.append("V");
            num -= 5;
        }else if(num +1 >= 5){
            ans.append("IV");
            num -= 4;
        }else{
            ans.append("I");
            num -= 1;
        }
        util(num);
    }
}