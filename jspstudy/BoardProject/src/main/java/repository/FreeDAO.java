package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Free;

public class FreeDAO {
	
	private SqlSessionFactory factory;

	private static FreeDAO dao = new FreeDAO();
	
	private FreeDAO() {
		try {
			// SqlSessionFactory 빌드
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static FreeDAO getInstance() {
		return dao;
	}
	
	String mapper = "mybatis.mapper.free.";
	
	public List<Free> selectAllFree() {
		SqlSession ss = factory.openSession();
		List<Free> frees = ss.selectList(mapper + "selectAllFree");
		ss.close();
		return frees;
	}
	
	public int insertFree(Free free) {
		SqlSession ss = factory.openSession();
		int result = ss.insert(mapper + "insertFree", free);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public int deleteFree(long freeNo) {
		SqlSession ss = factory.openSession();
		int result = ss.delete(mapper + "deleteFree", freeNo);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public Free selectFree(long freeNo) {
		SqlSession ss = factory.openSession();
		Free free = ss.selectOne(mapper + "selectFree", freeNo);
		ss.close();
		return free;
	}
	
	public int updateFree(Free free) {
		SqlSession ss = factory.openSession();
		int result = ss.update(mapper + "updateFree", free);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public Free topHitFree() {
		SqlSession ss = factory.openSession();
		Free free = ss.selectOne(mapper + "topHit");
		ss.close();
		return free;
	}

}
