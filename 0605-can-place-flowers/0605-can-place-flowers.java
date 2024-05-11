class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        if(n==0 && flowerbed.length>0){
            return true;
        }
        if(flowerbed.length==1){
            if(flowerbed[0]==0){
                if(n==1){
                    return true;
                }else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        if(flowerbed[0]==0 && flowerbed[1]==0){
            count++;
            flowerbed[0]=1;
            if(count==n){
                return true;
            }
        }
        if(flowerbed[flowerbed.length-2]==0 && flowerbed[flowerbed.length-1]==0){
            count++;
            flowerbed[flowerbed.length-1]=1;
            if(count==n){
                return true;
            }
        }
        for(int i=1;i<flowerbed.length-1;i++){
            if(flowerbed[i-1]==0 && flowerbed[i]==0 && flowerbed[i+1]==0){
                count++;
                flowerbed[i]=1;
                if(count==n){
                    return true;
                }
                continue;
            }
        }
        return false;
    }
}