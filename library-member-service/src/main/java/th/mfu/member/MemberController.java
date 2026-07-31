package th.mfu.member;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberMapper memberMapper;

    //find member by id
    @GetMapping("/members/{id}")
    public ResponseEntity<MemberDTO> getMemberById(@PathVariable Long id) {
        Optional<Member> member = memberRepository.findById(id);
        if (!member.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        MemberDTO memberDTO = memberMapper.toDTO(member.get());
        return ResponseEntity.ok(memberDTO);

        
    }

}
