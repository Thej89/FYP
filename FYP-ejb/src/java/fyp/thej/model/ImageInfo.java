/*
 * Final Year Project(EasyContact)
 */

package fyp.thej.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * ImageInfo
 * Apr 9, 2013 2:48:49 AM
 * Thejanee Walgamage <2008061>
 */
@Entity
@Table(name = "image_info", catalog = "easycontact", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImageInfo.findAll", query = "SELECT i FROM ImageInfo i"),
    @NamedQuery(name = "ImageInfo.findByImageId", query = "SELECT i FROM ImageInfo i WHERE i.imageInfoPK.imageId = :imageId"),
    @NamedQuery(name = "ImageInfo.findByImageName", query = "SELECT i FROM ImageInfo i WHERE i.imageName = :imageName"),
    @NamedQuery(name = "ImageInfo.findByImagePath", query = "SELECT i FROM ImageInfo i WHERE i.imagePath = :imagePath"),
    @NamedQuery(name = "ImageInfo.findByUserId", query = "SELECT i FROM ImageInfo i WHERE i.imageInfoPK.userId = :userId")})
public class ImageInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ImageInfoPK imageInfoPK;
    @Size(max = 45)
    @Column(name = "image_name")
    private String imageName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "image_path")
    private String imagePath;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public ImageInfo() {
    }

    public ImageInfo(ImageInfoPK imageInfoPK) {
        this.imageInfoPK = imageInfoPK;
    }

    public ImageInfo(ImageInfoPK imageInfoPK, String imagePath) {
        this.imageInfoPK = imageInfoPK;
        this.imagePath = imagePath;
    }

    public ImageInfo(int imageId, int userId) {
        this.imageInfoPK = new ImageInfoPK(imageId, userId);
    }

    public ImageInfoPK getImageInfoPK() {
        return imageInfoPK;
    }

    public void setImageInfoPK(ImageInfoPK imageInfoPK) {
        this.imageInfoPK = imageInfoPK;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (imageInfoPK != null ? imageInfoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImageInfo)) {
            return false;
        }
        ImageInfo other = (ImageInfo) object;
        if ((this.imageInfoPK == null && other.imageInfoPK != null) || (this.imageInfoPK != null && !this.imageInfoPK.equals(other.imageInfoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fyp.thej.model.ImageInfo[ imageInfoPK=" + imageInfoPK + " ]";
    }

}
