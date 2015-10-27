package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mybatis.orm.Blog;
import mybatis.orm.BlogMapper;

public class App {
	public static void main(String[] args) {
    	SqlSessionFactory sqlSessionFactory=null;
		// TODO Auto-generated method stub
		//TODO step1:create SqlSessionFactory
		//�����ļ���λ��
        String resource="mybatis/mybatis-config.xml";
        try {
			InputStream inputStream=Resources.getResourceAsStream(resource);
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(sqlSessionFactory!=null){
        	//����һ������xml�����ļ�
        	SqlSession session=sqlSessionFactory.openSession();
        	try{
        		Blog blog=(Blog)session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 1);
        		System.out.print(blog);
        	}finally{
        		session.close();
        	}
//          ������������ע��
//        	SqlSession session = sqlSessionFactory.openSession();
//        	try {
//        	  BlogMapper mapper = session.getMapper(BlogMapper.class);
//        	  Blog blog = mapper.selectBlog(1);
//        	} finally {
//        	  session.close();
//        	}
        	
        }
	}

}
