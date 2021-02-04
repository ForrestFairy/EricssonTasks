-module(zadanie1).
-export([change/1]).

change(File) -> 
    {ok, Inbinary} = file:read_file(File),
    {All, Bad, Good} = process_input(Inbinary),
    file:write_file("output.txt", "~d\n~p\n~p", [All, Bad, Good]),

    {All, Bad, Good}.

process_input(Inbinary) ->
    process(tuple_to_list(split_binary(Inbinary, 8)), 0, 0, []).

process([], All, Bad, Good) -> {All, Bad, Good};
process([Head | Tail], All, Bad, Good) ->
    
    case check_if_good(binary_to_integer(Head)) of
        false ->
            process(Tail, All + 1, Bad + 1, Good);
        true ->
            process(Tail, All + 1, Bad, Good ++ binary_to_list(Head))
        end.
    

check_if_good(Check) ->
    Control = Check rem 10,
    ID = Check div 10000,
    % io:fwrite("~p \n~p ~p", [ID, Control, ID rem 10]),
    is_good(Control, ID rem 10).

%Control and should be the same as the last digit of ID in binary
is_good(Control, Control) ->
    % io:fwrite("Hello \n"),
    true;
is_good(_, _) ->
    false.
