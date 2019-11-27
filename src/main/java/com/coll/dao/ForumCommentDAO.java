package com.coll.dao;

import java.util.List;

import com.coll.model.ForumComment;

public interface ForumCommentDAO {

	public boolean addForumComment(ForumComment comment);
	public ForumComment getForumComment(int commentId);
	public boolean deleteForumComment(ForumComment comment);
	public List<ForumComment> listComments();
	
}
