package com.ecjtu.jy.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

/**
 * ���ʵ����
 * @author ��ΰ
 * @date 20180724
 * @version 1.0
 * 
 */
public class Album {

	private Integer albumId;		 //���Id
	private String albumName;		 //�����
	private Timestamp albumCreatTime;	 //��ᴴ��ʱ��
	private Integer albumCreatorId;  //������Id
	private Integer albumPowerStatus;// ���Ȩ��״̬
	private String albumbg;
	private Set<Img>imgs;			 //����е�ͼƬ
	
	
	public Album(Integer albumId, String albumName, Timestamp albumCreatTime, Integer albumCreatorId,
			Integer albumPowerStatus) {
		super();
		this.albumId = albumId;
		this.albumName = albumName;
		this.albumCreatTime = albumCreatTime;
		this.albumCreatorId = albumCreatorId;
		this.albumPowerStatus = albumPowerStatus;
	}
	
	public Album(Integer albumId, String albumName, Timestamp albumCreatTime, Integer albumCreatorId,
			Integer albumPowerStatus,Set<Img>imgs) {
		this(albumId,albumName,albumCreatTime,albumCreatorId,albumPowerStatus);
		this.imgs = imgs;
		
	}
	
	
	public String getAlbumbg() {
		return albumbg;
	}

	public void setAlbumbg(String albumbg) {
		this.albumbg = albumbg;
	}

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Set<Img> getImgs() {
		return imgs;
	}

	public void setImgs(Set<Img> imgs) {
		this.imgs = imgs;
	}

	public Integer getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public Timestamp getAlbumCreatTime() {
		return albumCreatTime;
	}
	public void setAlbumCreatTime(Timestamp albumCreatTime) {
		this.albumCreatTime = albumCreatTime;
	}
	public Integer getAlbumCreatorId() {
		return albumCreatorId;
	}
	public void setAlbumCreatorId(Integer albumCreatorId) {
		this.albumCreatorId = albumCreatorId;
	}
	public Integer getAlbumPowerStatus() {
		return albumPowerStatus;
	}
	public void setAlbumPowerStatus(Integer albumPowerStatus) {
		this.albumPowerStatus = albumPowerStatus;
	}
	@Override
	public String toString() {
		return "Album [albumId=" + albumId + ", albumName=" + albumName + ", albumCreatTime=" + albumCreatTime
				+ ", albumCreatorId=" + albumCreatorId + ", albumPowerStatus=" + albumPowerStatus + "]";
	}

	
}
