package ru.netology.model;

public class Post {
  private boolean removed;
  private long id;
  private String content;

  public Post() {
  }

  public Post(long id, String content) {
    this.id = id;
    this.content = content;
    this.removed = false;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setRemoved(boolean removed) {
    this.removed = removed;
  }

  public boolean getRemoved() {
    return removed;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
