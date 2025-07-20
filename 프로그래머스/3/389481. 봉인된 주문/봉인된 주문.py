def solution(n, bans):
    # a~z = 26개
    def convertTo26(target):
        result = 0
        for c in target:
            result = result * 26 + (ord(c) - ord('a') + 1)
        return result
    
    def convertToString(value):
        num = value
        
        sb = []
        while num > 0:
            num = num - 1
            sb.append(chr(ord('a') + (num % 26)))
            num = num // 26
        return ''.join(reversed(sb))
        
    ban_values = sorted(convertTo26(ban) for ban in bans)
    
    current = n
    for l in ban_values:
        if (current >= l):
            current = current + 1
        else:
            break
        
    return convertToString(current)
