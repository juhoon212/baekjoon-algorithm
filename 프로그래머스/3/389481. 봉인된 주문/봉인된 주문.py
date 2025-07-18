def solution(n, bans):
    def convert_to_26(ban):
        result = 0
        for c in ban:
            result = result * 26 + (ord(c) - ord('a') + 1)
        return result

    def convert_to_string(target):
        num = target
        sb = []

        while num > 0:
            num -= 1  # 1 기반 → 0 기반으로 조정
            value = chr(ord('a') + (num % 26))
            sb.append(value)
            num //= 26

        return ''.join(reversed(sb))

    values = sorted([convert_to_26(ban) for ban in bans])
    target = n

    for value in values:
        if target >= value:
            target += 1
        else:
            break

    return convert_to_string(target)
