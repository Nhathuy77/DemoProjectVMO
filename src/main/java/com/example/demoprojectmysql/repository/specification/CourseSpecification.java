package com.example.demoprojectmysql.repository.specification;

import com.example.demoprojectmysql.model.dto.SearchCourseRequest;
import com.example.demoprojectmysql.model.entity.Course;
import org.springframework.data.jpa.domain.Specification;

public class CourseSpecification {


    public static Specification<Course> buildCondition(SearchCourseRequest request) {
        return Specification.where(buildConditionName(request))
                .and(buildConditionCourseType(request))
                .and(buildConditionStatus(request))
                .and(buildConditionPrice(request));
    }

    public static Specification<Course> buildConditionName(SearchCourseRequest request) {
        if (request.getCourseName() != null && !"".equals(request.getCourseName())) {
            // Tạo điều kiện tìm kiếm với name
            return (root, query, cri) -> {
// root: Chọn cột, field, để tìm kiếm (giá trị là thuộc tính trong java)
// cri: CriteriaBuilder Khai báo loại so sánh dữ liệu. ( lớn hơn, nhỏ hơn, equal, like,.... )
                return cri.like(root.get("courseName"), "%" + request.getCourseName() + "%");
            };
        } else {
            return null;
        }
    }


    public static Specification<Course> buildConditionStatus(SearchCourseRequest request){
        if (request.getStatus() != null){ //&& request.getStatus().size() > 0){
            return (root, query, cri) -> {
                // Tạo điều kiện tìm kiếm với courseType. CourseType sẽ là 1 trong các giá trị truyền vào
                return root.get("courseType").in(request.getStatus());
            };
        } else {
            return null;
        }
    }

    public static Specification<Course> buildConditionCourseType(SearchCourseRequest request){
        if (request.getCourseType() != null){ //&& request.getStatus().size() > 0){
            return (root, query, cri) -> {
                // Tạo điều kiện tìm kiếm với productType. ProductType sẽ là 1 trong các giá trị truyền vào
                return root.get("courseType").in(request.getCourseType());
            };
        } else {
            return null;
        }
    }

    public static Specification<Course> buildConditionPrice(SearchCourseRequest request){
        if (request.getMinPrice() != 0 && request.getMaxPrice() != 0){ // Nếu ko truyền phần tử nào -> lấy tất cả
            return (root, query, cri) -> {
                return cri.between(root.get("price"), request.getMinPrice(), request.getMaxPrice());
            };
        } else {
            return null;
        }
    }






}
