-module(zadanie1).
-export([change/1]).

change(File) -> 
    %read from file
    {ok, Inbinary} = file:read_file(File),
    
    {All, Bad, Good} = process_input(Inbinary),
    {ok, Output} = file:open("output.txt", [write]),
    io:format(Output, "~p\n~p\n~p", [All, Bad, Good]),
    {All, Bad, Good}.

process_input(Inbinary) ->
    List = split_file(Inbinary),
    process(List, 0, 0, []).

split_file(Inbinary) ->
    split_into_tuples(split_binary(Inbinary, 8), []).

%here A, B as binaries
split_into_tuples({A, B}, List) when size(B) == 0 ->
    [List | A];
split_into_tuples({A, B}, List) ->
    split_into_tuples(split_binary(B, 8), [List | binary_to_list(A)]).

process([], All, Bad, Good) -> {All, Bad, Good};

process([Head | Tail], All, Bad, Good) ->
    
    case check_if_good(Head) of
        false ->
            %if an object is bad count it and add to bad ones
            process(Tail, All + 1, Bad + 1, Good);
        true ->
            %if an object is good count it and add to the list of good ones
            process(Tail, All + 1, Bad, [Good | binary_to_list(Head)])
        end;
process(Head, All, Bad, Good) ->
    case check_if_good(Head) of
        false ->
            %if an object is bad count it and add to bad ones
            {All + 1, Bad + 1, Good};
        true ->
            %if an object is good count it and add to the list of good ones
            {All + 1, Bad, [Good | Head]}
        end.

check_if_good(Check) ->
    Control = Check rem 10,
    ID = Check div 10000,
    is_good(Control, ID rem 10).

% Control and should be the same as the last digit of ID in binary
% because the last digit tells if binary is odd or even
is_good(Control, Control) ->
    true;
is_good(_, _) ->
    false.
