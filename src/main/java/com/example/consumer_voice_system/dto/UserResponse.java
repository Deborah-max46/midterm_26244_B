package com.example.consumer_voice_system.dto;

public class UserResponse {
    
    private Long id;
    private String fullName;
    private String email;
    private LocationHierarchy location;
    
    // Constructors
    public UserResponse() {
    }
    
    public UserResponse(Long id, String fullName, String email, LocationHierarchy location) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.location = location;
    }
    
    // Getters and Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFullName() {
        return fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public LocationHierarchy getLocation() {
        return location;
    }
    
    public void setLocation(LocationHierarchy location) {
        this.location = location;
    }
    
    // Inner class for location hierarchy
    public static class LocationHierarchy {
        private String village;
        private String villageCode;
        private String cell;
        private String cellCode;
        private String sector;
        private String sectorCode;
        private String district;
        private String districtCode;
        private String province;
        private String provinceCode;
        
        // Constructors
        public LocationHierarchy() {
        }
        
        // Getters and Setters
        public String getVillage() {
            return village;
        }
        
        public void setVillage(String village) {
            this.village = village;
        }
        
        public String getVillageCode() {
            return villageCode;
        }
        
        public void setVillageCode(String villageCode) {
            this.villageCode = villageCode;
        }
        
        public String getCell() {
            return cell;
        }
        
        public void setCell(String cell) {
            this.cell = cell;
        }
        
        public String getCellCode() {
            return cellCode;
        }
        
        public void setCellCode(String cellCode) {
            this.cellCode = cellCode;
        }
        
        public String getSector() {
            return sector;
        }
        
        public void setSector(String sector) {
            this.sector = sector;
        }
        
        public String getSectorCode() {
            return sectorCode;
        }
        
        public void setSectorCode(String sectorCode) {
            this.sectorCode = sectorCode;
        }
        
        public String getDistrict() {
            return district;
        }
        
        public void setDistrict(String district) {
            this.district = district;
        }
        
        public String getDistrictCode() {
            return districtCode;
        }
        
        public void setDistrictCode(String districtCode) {
            this.districtCode = districtCode;
        }
        
        public String getProvince() {
            return province;
        }
        
        public void setProvince(String province) {
            this.province = province;
        }
        
        public String getProvinceCode() {
            return provinceCode;
        }
        
        public void setProvinceCode(String provinceCode) {
            this.provinceCode = provinceCode;
        }
    }
}
