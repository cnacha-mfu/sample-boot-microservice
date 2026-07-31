package th.mfu.member;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    MemberDTO toDTO(Member member);
    Member toEntity(MemberDTO memberDTO);
}
