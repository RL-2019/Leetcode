class Solution {
    public int myAtoi(String str) {
        if(str==null ||str.length()<1){
            return 0;
        }
        //remove space
        str = str.trim();
        if(str.length()<1){
            return 0;
        }
        
        int i = 0;
        double result = 0;
        char flag = '+';
        if(str.charAt(0) == '-'){
            flag = '-';
            i++;
            
        }else if(str.charAt(0)== '+'){
            i++;
        }
        while(str.length()>i &&(str.charAt(i)>='0'&&str.charAt(i)<='9')){
            result = result*10+str.charAt(i)-'0';
            i++;
            
        }
        if(flag=='-'){
              result = -result;
        }
        //handle max and min
        if(result >Integer.MAX_VALUE){
            result = Integer.MAX_VALUE;
        }else if(result < Integer.MIN_VALUE){
            result = Integer.MIN_VALUE;
        }
        return (int) result;
        
    }
}

