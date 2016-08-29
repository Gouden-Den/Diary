package service;

import java.util.List;

import dao.DiaryDao;
import domain.Diary;

public class DiaryService {
	private DiaryDao diaryDao;
	
	public Diary getDiary(int diaryid){
		return diaryDao.getDiary(diaryid);
	}
	public boolean addDiary(Diary diary){
		return diaryDao.addDiary(diary);
	}
	public boolean updateDiary(Diary diary){
		return diaryDao.updateDiary(diary);
	}
	public boolean deleteDiary(int diaryid){
		return diaryDao.deleteDiary(diaryid);
	}
	public List<Diary> getDiaryByMonth(int month){
		return diaryDao.getDiaryByMonth(month);
	}
	public List<Diary> getAllDiaryASC(int userid){
		return diaryDao.getAllDiaryASC(userid);
	}
	public List<Diary> getAllDiaryDesc(int userid){
		return diaryDao.getAllDiaryDesc(userid);
	}
	
	public DiaryDao getDiaryDao() {
		return diaryDao;
	}

	public void setDiaryDao(DiaryDao diaryDao) {
		this.diaryDao = diaryDao;
	}
}
