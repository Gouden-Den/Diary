package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import domain.Diary;

public class DiaryDao {
	private SessionFactory sessionFactory;
	
	//�鿴�ռ�
	public Diary getDiary(int diaryid){
		Session session = sessionFactory.openSession();
		Diary diary = (Diary) session.get(Diary.class, diaryid);
		session.close();
		return diary;
	}
	
	//����ռ�
	public boolean addDiary(Diary diary){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean flag = false;
		try{
			tx = session.beginTransaction();
			session.save(diary);
			flag = true;
			tx.commit();
			return flag;
		}catch(Exception e){
			tx.rollback();
			throw new RuntimeException();
		}finally{
			session.close();
		}
	}
	
	//�޸��ռ�
	public boolean updateDiary(Diary diary){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean flag = false;
		try{
			tx = session.beginTransaction();
			session.update(diary);
			flag = true;
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			throw new RuntimeException();
		}finally{
			session.close();
		}
		
		return flag;
	}
	
	//ɾ���ռ�
	public boolean deleteDiary(int diaryid){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		boolean flag = false;
		try{
			tx = session.beginTransaction();
			Diary diary = (Diary) session.get(Diary.class, diaryid);
			session.delete(diary);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			throw new RuntimeException();
		}finally{
			session.close();
		}
		
		return flag;
	}
	
	//���·ݵõ��ռ�
	public List<Diary> getDiaryByMonth(int month){
		Session session = sessionFactory.openSession();
		String hql = "from Diary where month="+month;
		List<Diary> list = session.createQuery(hql).list();
		session.close();
		return list;
	}
	
	//����������õ������ռ�
	public List<Diary> getAllDiaryASC(int userid){
		Session session = sessionFactory.openSession();
		String hql = "from Diary where userid="+userid+" order by createTime asc";
		List<Diary> list = session.createQuery(hql).list();
		session.close();
		return list;
	}
	
	//�����ڽ���õ������ռ�
	public List<Diary> getAllDiaryDesc(int userid){
		Session session = sessionFactory.openSession();
		String hql = "from Diary where userid="+userid+" order by createTime desc";
		List<Diary> list = session.createQuery(hql).list();
		session.close();
		return list;
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
