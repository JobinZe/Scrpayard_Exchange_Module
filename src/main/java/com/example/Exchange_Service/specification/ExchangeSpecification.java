package com.example.Exchange_Service.specification;

import com.example.Exchange_Service.dto.SearchExchangeRequestDto;
import com.example.Exchange_Service.entity.SearchExchange;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ExchangeSpecification {
    public static Specification<SearchExchange> byFilter(SearchExchangeRequestDto request){
      return (root, query, criteriaBuilder) -> {
          List<Predicate> predicates = new ArrayList<>();
          if(StringUtils.hasText(request.getName())){
              predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + request.getName().toLowerCase() + "%"));//% like queries matches any character that matches the request string
          }
          if (StringUtils.hasText(request.getEmail())) {
              predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), "%" + request.getEmail().toLowerCase() + "%"));
          }
          if (StringUtils.hasText(request.getItem_name())) {
              predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("item_name")), "%" + request.getItem_name().toLowerCase() + "%"));
          }
          if (request.getCategory()!=null) {
              predicates.add(criteriaBuilder.like(root.get("category"), "%" + request.getItem_name() + "%"));
          }
          if (request.getPosted_on()!=null) {
              predicates.add(criteriaBuilder.equal(root.get("posted_on"), request.getPosted_on()));
          }
           if(request.getPrice()!=null){
              predicates.add(criteriaBuilder.equal(root.get("price"),request.getPrice()));
          }
           return criteriaBuilder.and(predicates.toArray(new Predicate[0]));//and will combine all queries
      };
    }
}
