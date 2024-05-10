class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<String>();
        for(String str: emails){
             int index = str.indexOf('@');
             String local = str.substring(0,index);
             String domain = str.substring(index,str.length());
             local = local.replace(".","");
             int plusIndex = local.indexOf('+');
             if(plusIndex!=-1){
                local = local.substring(0,plusIndex);
             }
             set.add(local+domain);
        }
        return set.size();
    }
}