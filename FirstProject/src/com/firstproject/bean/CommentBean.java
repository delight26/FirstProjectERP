package com.firstproject.bean;

public class CommentBean {
   
   private String commentNum;
   private String commentContent;
   private String commentCreator;
   private String commentDate;
   private String commentReplyTo;
   private String postNum;
   private String creatorName;
   private String ReplyToName;
   
   
   public CommentBean() {}
   
   public CommentBean(String commentNum, String commentContent, String commentCreator,
         String commentDate, String commentReplyTo, String postNum) {
      
      this.commentNum = commentNum;
      this.commentContent = commentContent;
      this.commentCreator = commentCreator;
      this.commentDate = commentCreator;
      this.commentReplyTo = commentReplyTo;
      this.postNum = postNum;
      
   }
   
   
   public String getCommentNum() {
      return commentNum;
   }
   public void setCommentNum(String commentNum) {
      this.commentNum = commentNum;
   }
   public String getCommentContent() {
      return commentContent;
   }
   public void setCommentContent(String commentContent) {
      this.commentContent = commentContent;
   }
   public String getCommentCreator() {
      return commentCreator;
   }
   public void setCommentCreator(String commentCreator) {
      this.commentCreator = commentCreator;
   }
   public String getCommentDate() {
      return commentDate;
   }
   public void setCommentDate(String commentDate) {
      this.commentDate = commentDate;
   }


   public String getCommentReplyTo() {
      return commentReplyTo;
   }


   public void setCommentReplyTo(String commentReplyTo) {
      this.commentReplyTo = commentReplyTo;
   }


   public String getPostNum() {
      return postNum;
   }


   public void setPostNum(String postNum) {
      this.postNum = postNum;
   }

   public String getCreatorName() {
      return creatorName;
   }

   public void setCreatorName(String creatorName) {
      this.creatorName = creatorName;
   }

   public String getReplyToName() {
      return ReplyToName;
   }

   public void setReplyToName(String replyToName) {
      ReplyToName = replyToName;
   }
   
   

}