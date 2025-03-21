def solution(video_len, pos, op_start, op_end, commands):
    vl_m = video_len[0:2]
    vl_s = video_len[3:5]
    vl = int(vl_m)*60 + int(vl_s)
    
    pos_m = pos[0:2]
    pos_s = pos[3:5]
    ppos = int(pos_m)*60 + int(pos_s)
    
    os_m = op_start[0:2]
    os_s = op_start[3:5]
    os = int(os_m)*60 + int(os_s)
    
    oe_m = op_end[0:2]
    oe_s = op_end[3:5]
    oe = int(oe_m)*60 + int(oe_s)
    for command in commands:
        if os <= ppos <= oe:
            ppos = oe
       
        if command == "prev":
            ppos = max(0, ppos-10)


        elif command == "next":
            ppos = min(vl, ppos+10)

        if os <= ppos <= oe:
            ppos = oe

        
                

    result1 = str(ppos//60)
    result2 = str(ppos%60)
    
    if ppos//60 >=10:
        answer = result1+":"+result2
        if ppos%60 < 10:
            answer = result1+":"+"0"+result2
    else:
        answer = "0"+result1+':'+result2
        if ppos%60 < 10:
            answer = "0"+result1+":"+"0"+result2
    return answer