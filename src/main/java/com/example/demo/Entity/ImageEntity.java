package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity(name = "Image")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@Column(name = "path")
    private String path;

	@Column(name = "info")
    private String info;

	@ManyToOne
	@JoinColumn(name = "category_image_id")
	private CategoryImageEntity categoryImage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public CategoryImageEntity getCategoryImage() {
		return categoryImage;
	}

	public void setCategoryImage(CategoryImageEntity categoryImage) {
		this.categoryImage = categoryImage;
	}
}
