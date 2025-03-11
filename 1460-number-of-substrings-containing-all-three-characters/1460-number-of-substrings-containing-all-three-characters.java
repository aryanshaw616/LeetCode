class Solution {
    public int numberOfSubstrings(String s) {
        int l = s.length();
        int a[], b[], c[];
        a = new int[l];
        b = new int[l];
        c = new int[l];

        char[] sc = s.toCharArray();
        int lasta = -1, lastb = -1, lastc = -1;
        for(int i = l-1; i> -1; i--){
            if(sc[i] == 'a'){
                lasta = i;
            }else if(sc[i] == 'b'){
                lastb = i;
            }else{
                lastc = i;
            }
            a[i] = lasta;
            b[i] = lastb;
            c[i] = lastc;
        }
        int count = 0;
        int lasti = -1;
        for(int i = 0; i< l; i++){
            if(a[i] == -1 || b[i] == -1 || c[i] == -1){
                break;
            }
            if(sc[i] == 'a'){
                lasti = Math.max(b[i],c[i]);
            }else if(sc[i] == 'b'){
                lasti = Math.max(a[i],c[i]);
            }else{
                lasti = Math.max(a[i],b[i]);
            }
            count += (l - lasti);
        }
        return count;   
    }
}