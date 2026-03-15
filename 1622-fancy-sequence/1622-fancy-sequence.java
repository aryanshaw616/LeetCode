class Fancy {
    int  max=100000;
    long mod=1000000007;
    long[] seg=new long[4*max];
    long[] lazy1=new long[4*max];
    long[] lazy2=new long[4*max];
    int size=0;
    public Fancy() {
        Arrays.fill(lazy2,1);
    }
    void updateRange(int start,int end,int i,int l,int r,long mul,long add){
        if(lazy1[i]!=0 || lazy2[i]!=1){
            seg[i]=(seg[i]*lazy2[i]+(r-l+1)*lazy1[i])%mod;
            if(l!=r){
                lazy2[2*i+1]=(lazy2[2*i+1]*lazy2[i])%mod;
                lazy2[2*i+2]=(lazy2[2*i+2]*lazy2[i])%mod;
                lazy1[2*i+1]=(lazy1[2*i+1]*lazy2[i]+lazy1[i])%mod;
                lazy1[2*i+2]=(lazy1[2*i+2]*lazy2[i]+lazy1[i])%mod;
            }
            lazy2[i]=1;
            lazy1[i]=0;
        }
        if(l>end || r<start || l>r) return;
        if(l>=start && r<=end){
            seg[i]=(seg[i]*mul+(r-l+1)*add)%mod;
            if(l!=r){
                lazy2[2*i+1]=(lazy2[2*i+1]*mul)%mod;
                lazy2[2*i+2]=(lazy2[2*i+2]*mul)%mod;
                lazy1[2*i+1]=(lazy1[2*i+1]*mul+add)%mod;
                lazy1[2*i+2]=(lazy1[2*i+2]*mul+add)%mod;
            }
            return;
        }
        int mid=l+(r-l)/2;
        updateRange(start,end,2*i+1,l,mid,mul,add);
        updateRange(start,end,2*i+2,mid+1,r,mul,add);
        seg[i]=(seg[2*i+1]+seg[2*i+2])%mod;
    }
    long query(int ind,int i,int l,int r){
        if(lazy1[i]!=0 || lazy2[i]!=1){
            seg[i]=(seg[i]*lazy2[i]+(r-l+1)*lazy1[i])%mod;
            if(l!=r){
                lazy2[2*i+1]=(lazy2[2*i+1]*lazy2[i])%mod;
                lazy2[2*i+2]=(lazy2[2*i+2]*lazy2[i])%mod;
                lazy1[2*i+1]=(lazy1[2*i+1]*lazy2[i]+lazy1[i])%mod;
                lazy1[2*i+2]=(lazy1[2*i+2]*lazy2[i]+lazy1[i])%mod;
            }
            lazy2[i]=1;
            lazy1[i]=0;
        }
        if(l==r) return seg[i];
        int mid=l+(r-l)/2;
        if(ind<=mid) return query(ind,2*i+1,l,mid);
        else{
            return query(ind,2*i+2,mid+1,r);
        }
    }
    public void append(int val) {
        updateRange(size,size,0,0,max-1,1,val);
        size++;
    }
    public void addAll(int inc) {
        if(size==0) return;
        updateRange(0,size-1,0,0,max-1,1,inc);
    }
    public void multAll(int m) {
        if(size==0) return;
        updateRange(0,size-1,0,0,max-1,m,0);
    }
    public int getIndex(int idx) {
        if(idx>=size) return -1;
        return(int)query(idx,0,0,max-1);
    }
}