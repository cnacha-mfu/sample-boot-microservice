package th.mfu.transaction;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "library-member-service")
public interface MemberClient {

    @GetMapping("/api/members/{id}")
    MemberDTO getMemberById(@PathVariable Long id);

}
