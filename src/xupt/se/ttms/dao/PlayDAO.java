package xupt.se.ttms.dao;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import xupt.se.ttms.idao.iPlayDAO;
import xupt.se.ttms.model.Play;
import xupt.se.util.DBUtil;

public class PlayDAO implements iPlayDAO {
	@SuppressWarnings("finally")
	public int insert (Play play)
	{
		int result = 0;
		try
		{
			String sql = "insert into play(play_type_id, play_lang_id, play_name, play_introduction, play_image, play_video, play_length, play_ticketPrice)" + "values('"+play.getType_id()+"', '"+play.getLang_id()+"', '"+play.getName()+"', '"+play.getIntroduction()+"', "
					+ "'"+play.getImage()+"', '"+play.getLength()+"', "
					+ "'"+play.getTicketPrice()+"')";
			DBUtil db = new DBUtil();
			db.openConnection();
			ResultSet rst = db.getInsertObjectIDs(sql);
			if(rst != null && rst.first())
			{
				play.setID(rst.getInt(1));
			}
			db.close(rst);
			db.close();
			result = 1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			return result;
		}
	}
	
	@SuppressWarnings("finally")
	public int update(Play play)
	{
		int result = 0;
		try
		{
			String sql = "update studio set" + play.getType_id()+"', '"+play.getLang_id()+"', '"+play.getName()+"', '"+play.getIntroduction()+"', "
					+ "'"+play.getImage()+"', '"+play.getLength()+"', "
					+ "'"+play.getTicketPrice() + "''";
			sql += "where play_id = " + play.getID();
			DBUtil db = new DBUtil();
			db.openConnection();
			result = db.execCommand(sql);
			db.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			return result;
		}
	}
	
	@Override
	public int delete(int ID)
	{
		int result = 0;
		try
		{
			String sql = "delete from play where play_id = " + ID;
			DBUtil db = new DBUtil();
			db.openConnection();
			result = db.execCommand(sql);
			db.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	@SuppressWarnings("finally")
	public String selectplayid(int condt)
	{
		DBUtil db = null;
		String result = "";
		try
		{
			String sql = "select play_name from play where play_id = " + condt;
			db = new DBUtil();
			if(!db.openConnection())
			{
				System.out.print("fail to connect database");
				return null;
			}
			ResultSet rst = db.execQuery(sql);
			if(rst != null)
			{
				while(rst.next())
				{
					result = rst.getNString("play_id");
				}
			}
			db.close(rst);
			db.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			return result;
		}
	}
	
	@SuppressWarnings("finally")
  @Override
  public List<Play> select(String playName)
  {
      DBUtil db=null;
      List<Play> playList = null;
      playList=new LinkedList<Play>();
      try
      {
          playName.trim();
          String sql="select * from play where play_name like '%" + playName + "%'";
          db=new DBUtil();
          if(!db.openConnection())
          {
              System.out.print("fail to connect database");
              return null;
          }
          ResultSet rst=db.execQuery(sql);
          if(rst != null)
          {
              while(rst.next())
              {
                  Play play=new Play();
                  play.setID(rst.getInt("play_id"));
                  play.setName(rst.getString("play_name"));
                  play.setIntroduction(rst.getString("play_introduction"));
                  play.setImage(rst.getString("play_image"));
                  play.setType_id(rst.getInt("play_type_id"));
                  play.setLang_id(rst.getInt("play_lang_id"));
                  play.setLength(rst.getInt("play_length"));
                  play.setTicketPrice(rst.getFloat("play_ticketPrice"));
                  playList.add(play);
              }
          }
          db.close(rst);
          db.close();
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
      finally
      {
          return playList;
      }
  }


}



