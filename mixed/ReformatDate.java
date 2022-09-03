class Solution {
    public String reformatDate(String date) {

        Map<String,String> months=new HashMap<>();
        months.put("Jan","01");
        months.put("Feb","02");
        months.put("Mar","03");
        months.put("Apr","04");
        months.put("May","05");
        months.put("Jun","06");
        months.put("Jul","07");
        months.put("Aug","08");
        months.put("Sep","09");
        months.put("Oct","10");
        months.put("Nov","11");
        months.put("Dec","12");
        String[] arr=date.split(" ");
        StringBuilder day=new StringBuilder(arr[0]);
        day.deleteCharAt(day.length()-1).deleteCharAt(day.length()-1);
        if(day.length()==1){
            day=new StringBuilder("0").append(day);
        }
        String month= months.get(arr[1]);
        String result=arr[2]+"-"+month+"-"+day.toString();
        return result;
        
    }
}
