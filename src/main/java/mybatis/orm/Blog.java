package mybatis.orm;

public class Blog {
    private int id;
    private String name;
//    public Blog(int id){
//    	this.id=id;
//    }
//    public Blog(){
//    	
//    }
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
     
	@Override
	public String toString(){
		return this.getClass().getName()+" id is: "+this.id+" name is: "+this.name;
	}
}
